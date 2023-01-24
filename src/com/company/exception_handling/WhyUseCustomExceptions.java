package com.company.exception_handling;

import java.util.Arrays;
import java.util.List;

public class WhyUseCustomExceptions {
}

/*

Overview
    
    In this article, we'll cover the process of creating custom both checked and unchecked exceptions in Java.



Навіщо використовувати користувацькі (кастомні) винятки?

    Незважаючи на те, що ті винятки, які є у Java охоплюють майже всі виняткові випадки та умови, 
    ваша програма може створити особливий виняток, унікальний для вашого коду та логіки.
    
    Іноді нам потрібно створити власні для представлення винятків бізнес-логіки, тобто винятків, які є специфічними 
    для нашої бізнес-логіки або робочого процесу. Наприклад EmailNotUniqueException, InvalidUserStateException тощо.
    
    Вони допомагають клієнтам програми краще зрозуміти, що пішло не так. 
    Вони особливо корисні для обробки винятків для REST API, оскільки різні обмеження бізнес-логіки вимагають 
    надсилання клієнту різних кодів відповіді.
    
    Якщо визначення користувацьких винятків не дає переваги порівняно з використанням звичайних винятків у Java, 
    немає потреби визначати користувацькі винятки, і вам слід просто дотримуватися тих, які вже доступні – 
    не потрібно знову вигадувати велосипед.



Custom Checked Exception - Спеціальний перевірений виняток

    Давайте розглянемо сценарій, коли ми хочемо перевірити електронний лист, який передається як аргумент методу.


    Ми хочемо перевірити, дійсний він чи ні. Тепер ми можемо використовувати вбудований Java IllegalArgumentException, 
    що добре, якщо ми просто перевіряємо одну річ, наприклад, чи відповідає вона попередньо визначеному REGEX чи ні.

    Але припустімо, що ми також маємо бізнес-умову перевірити, що всі електронні листи в нашій системі повинні 
    бути унікальними. Тепер ми повинні виконати другу перевірку (виклик БД/мережі). 
    Ми, звичайно, можемо використовувати IllegalArgumentException, але буде незрозуміло, у чому полягає точна причина:
    чи електронний лист не пройшов перевірку REGEX, чи електронний лист уже існує в базі даних.
    
    Давайте створимо спеціальний виняток, щоб вирішити цю ситуацію. 
    Щоб створити виняток, як і будь-який інший виняток, ми повинні розширити java.lang.Exception клас:

 */

class EmailNotUniqueException extends Exception {

    public EmailNotUniqueException(String message) {
        super(message);
    }
}

/*

    Зверніть увагу, що ми надали конструктор, який приймає повідомлення про String помилку та викликає конструктор 
    батьківського класу. Тепер це не є обов’язковим, але є звичайною практикою мати певні відомості про виняток, який стався.
    
    Викликаючи super(message), ми ініціалізуємо повідомлення про помилку винятку, а базовий клас піклується про 
    налаштування спеціального повідомлення відповідно до message.
    
    Тепер давайте використаємо цей власний виняток у нашому коді. Оскільки ми визначаємо метод, який може викликати 
    виняток на рівні служби, ми позначимо його ключовим словом throws.
    
    Якщо вхідна електронна адреса вже існує в нашій базі даних (у цьому випадку це список), ми викидаємо 
    throw нашого кастомного винятку:

 */

class RegistrationService {
    List<String> registeredEmails = Arrays.asList("abc@gmail.com", "xyz@gmail.com");

    public void validateEmail(String email) throws EmailNotUniqueException {
        if (registeredEmails.contains(email)) {
            throw new EmailNotUniqueException("Email Already Registered");
        }
    }
}

/*
    Тепер давайте напишемо клієнта для нашого сервісу. Оскільки це перевірений виняток, ми повинні дотримуватися 
    правила обробки або оголошення. У наступному прикладі ми вирішили «обробити» це:
 */

class RegistrationServiceClient {
    public static void main(String[] args) {
        RegistrationService service = new RegistrationService();
        try {
            service.validateEmail("abc@gmail.com");
        } catch (EmailNotUniqueException e) {
            // logging and handling the situation    // <= Примітка. Процес обробки винятків опущено для стислості, але це важливий процес.
        }
    }
}

// Запуск цього фрагмента коду дасть:

/*
    ... .exception.EmailNotUniqueException: Email Already Registered  
        at mynotes.custom.checked.exception.RegistrationService.validateEmail(RegistrationService.java:12)
        at mynotes.custom.checked.exception.RegistrationServiceClient.main(RegistrationServiceClient.java:9)

 */


/*

Custom Unchecked Exception - Спеціальний неперевірений виняток

    Це працює чудово, але наш код став трохи безладним. Крім того, ми змушуємо клієнта фіксувати наше виключення 
    в try-catch блоці. У деяких випадках це може призвести до того, що розробники змушені писати шаблонний код.
    
    У цьому випадку може бути корисним замість цього створити custom runtime exception. 
    Щоб створити custom unchecked exception (спеціальний неперевірений виняток), 
    ми повинні розширити клас java.lang.RuntimeException
    
    Давайте розглянемо ситуацію, коли нам потрібно перевірити, чи електронний лист має дійсне доменне ім’я чи ні:
*/

class DomainNotValidException extends RuntimeException {

    public DomainNotValidException(String message) {
        super(message);
    }
}

class RegistrationService2 {

    public void validateEmail(String email) {
        if (!isDomainValid(email)) {
            throw new DomainNotValidException("Invalid domain");
        }
    }

    private boolean isDomainValid(String email) {
        List<String> validDomains = Arrays.asList("gmail.com", "yahoo.com", "outlook.com");
        if (validDomains.contains(email.substring(email.indexOf("@") + 1))) {
            return true;
        }
        return false;
    }
}

/*
Зверніть увагу, що нам не потрібно було використовувати ключові слова throws в сигнатурі методу, оскільки це неперевірений виняток.

Тепер давайте напишемо клієнта для нашого сервісу. Цього разу нам не потрібно використовувати try-catch блок:

 */

class RegistrationServiceClient2 {

    public static void main(String[] args) {
        RegistrationService2 service = new RegistrationService2();
        service.validateEmail("abc@gmail1.com");
    }
}
/*
    Запуск цього фрагмента коду дасть:

    Exception in thread "main" com.company.exception_handling.DomainNotValidException: Invalid domain
        at com.company.exception_handling.RegistrationService2.validateEmail(WhyUseCustomExceptions.java:137)
        at com.company.exception_handling.RegistrationServiceClient2.main(WhyUseCustomExceptions.java:161)


    
    Примітка: звичайно, ви можете оточити свій код try-catch блоком для захоплення виниклої виняткової ситуації, 
              але тепер це не примусово компілятор.
 */

class RethrowingAnExceptionWrappedInsideACustomException{
    
}

/*
    Rethrowing an Exception Wrapped Inside a Custom Exception
    
        Повторне створення винятку, загорнутого в користувацький виняток
    
    Іноді нам потрібно переловити виняток і повторно створити його, додавши ще кілька деталей. 
    Зазвичай це часто трапляється, якщо у вашій програмі визначено різні коди помилок, які потрібно або реєструвати, 
    або повертати клієнту у випадку конкретного винятку.

    Припустимо, ваша програма має стандартний ErrorCodes клас:

 */

enum ErrorCodes {
    VALIDATION_PARSE_ERROR(422);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

class InvalidCurrencyDataException extends RuntimeException {

    private Integer errorCode;

    public InvalidCurrencyDataException(String message) {
        super(message);
    }

    public InvalidCurrencyDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCurrencyDataException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}

/*

    Зверніть увагу, що у нас є кілька конструкторів, і дозвольте класу обслуговування вирішити, який з них використовувати. 
    Оскільки ми перевикидаємо виняток, завжди корисно фіксувати першопричину виключення, отже, Throwable аргумент 
    можна передати конструктору батьківського класу.
    
    Ми також фіксуємо код помилки в одному з конструкторів і встановлюємо errorCode в самому винятку. 
    Клієнт errorCode може використовувати для журналювання чи будь-яких інших цілей. 
    Це допомагає створити більш централізований стандарт для обробки винятків.

 */

class CurrencyService {
    public String convertDollarsToEuros(String value) {
        try {
            int x = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new InvalidCurrencyDataException("Invalid data", e, ErrorCodes.VALIDATION_PARSE_ERROR);
        }
        return value;
    }
}

/*
    Так ми зловили стандарт NumberFormatException і закинули свій InvalidCurrencyDataException. 
    Ми передали батьківський виняток нашому спеціальному винятку, щоб не втратити першопричину, через яку виник цей ексепшн.
    
    Давайте напишемо тестовий клієнт для цієї служби:
 */
class CurrencyClient {
    public static void main(String[] args) {
        CurrencyService service = new CurrencyService();
        service.convertDollarsToEuros("asd");
    }
}

/*

    Exception in thread "main" com.company.exception_handling.InvalidCurrencyDataException: Invalid data
        at com.company.exception_handling.CurrencyService.convertDollarsToEuros(WhyUseCustomExceptions.java:247)
        at com.company.exception_handling.CurrencyClient.main(WhyUseCustomExceptions.java:262)
    Caused by: java.lang.NumberFormatException: For input string: "asd"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        at java.base/java.lang.Integer.parseInt(Integer.java:668)
        at java.base/java.lang.Integer.parseInt(Integer.java:786)
        at com.company.exception_handling.CurrencyService.convertDollarsToEuros(WhyUseCustomExceptions.java:245)
        ... 1 more
        
        
        
   Як бачите, ми маємо чудове стекове трасування винятку, яка може бути корисною для налагодження.     
 */

/*
    Найкращі методи використання спеціальних винятків

        > Дотримуйтеся загальної конвенції про іменування в усій екосистемі Java – усі назви власних класів винятків 
            мають закінчуватися на «Exception»
        
        > Уникайте створення спеціальних винятків, якщо стандартні винятки з самого JDK можуть служити цій меті. 
            У більшості випадків немає потреби визначати спеціальні винятки.
            
        > Надавайте перевагу runtime exceptions (виняткам під час виконання), а не checked exceptions (перевіреним виняткам). 
            Такі фреймворки, як Spring, загорнули всі перевірені винятки у винятки часу виконання, а отже і не змушують
            клієнта писати шаблонний код, який він не хоче чи не потребує.
            
        > Створіть багато перевантажених конструкторів для custom exception. Якщо він використовується для 
            перевикидання існуючого винятку, тоді обов’язково надайте конструктор, який встановлює причину.

 */