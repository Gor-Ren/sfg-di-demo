package guru.springframework.didemo.services;

import java.lang.reflect.Constructor;

public class GreetingServiceFactory {

    private enum Language {
        ENGLISH(PrimaryEnglishGreetingService.class),
        SPANISH(PrimarySpanishGreetingService.class),
        GERMAN(PrimaryGermanGreetingService.class);

        private Class<? extends GreetingService> greetingServiceType;

        Language(Class<? extends GreetingService> greetingServiceType) {
            this.greetingServiceType = greetingServiceType;
        }

        public GreetingService getGreetingServiceInstance(GreetingRepository greetingRepository) {
            GreetingService service;
            try {
                Constructor<? extends GreetingService> constructor =
                        greetingServiceType.getConstructor(GreetingRepository.class);
                service = constructor.newInstance(greetingRepository);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Unable to create greeting service for language " + this, e);
            }
            return service;
        }
    }

    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String rawLanguage) {
        Language language = Language.valueOf(rawLanguage);
        return language.getGreetingServiceInstance(greetingRepository);
    }
}
