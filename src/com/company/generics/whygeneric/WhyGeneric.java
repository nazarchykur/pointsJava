package com.company.generics.whygeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class WhyGeneric {
    public static void main(String[] args) {
        /*
            Під час створення дженерика ти вказуєш його тип, а також тип даних, із якими він має працювати. 
            найочевидніший приклад — це ArrayList! Ось як ми зазвичай створюємо його у програмі:
         */
        List<String> myList1 = new ArrayList<>();
        myList1.add("Test String 1");
        myList1.add("Test String 2");
        
        
        /*
            особливість списку полягає в тому, що в нього не можна буде «запихати» будь-що: він працює виключно з об'єктами String. 
       
            Тепер давай зробимо невеликий екскурс в історію Java і спробуємо відповісти на запитання: навіщо?
         */
        class MyListClass {
            private Object[] data;
            private int count;

            public MyListClass() {
                this.data = new Object[10];
                this.count = 0;
            }

            public void add(Object o) {
                this.data[count] = o;
                count++;
            }

            public Object[] getData() {
                return data;
            }
        }
        /*
            Допустимо, ми хочемо, щоб наш список зберігав лише числа Integer
            Дженеріків у нас немає. Ми не можемо явно вказати перевірку o instance of Integer у методі add(). 
            Тоді весь наш клас буде придатний тільки для Integer, і нам доведеться писати такий самий клас для всіх існуючих типів даних!
         */

        MyListClass list = new MyListClass();
        list.add(100);
        list.add(200);
        list.add("some text 1");
        list.add("some text 2");

        Integer sum1 = (Integer) list.getData()[0] + (Integer) list.getData()[1];
        System.out.println(sum1);

//        Integer sum2 = (Integer) list.getData()[2] + (Integer) list.getData()[3]; //Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
//        System.out.println(sum2);
        
        /*
            Висновок в консоль:
            Exception in thread "main" java.lang.ClassCastException: java.lang 
       
            Найгірше те, що неправильний код потрапив у важливе місце нашої програми та успішно скомпілювався. 
       
            Саме в цьому полягає перевага дженериків: клас-дженерик дозволить програмісту виявити помилку відразу ж. 
            Код просто не скомпілюється!
         */

        List<Integer> myList2 = new ArrayList<>();

        myList2.add(100);
        myList2.add(100);
//        myList2.add("some text 1"); //помилка!
//        myList2.add("some text 2"); //помилка!
        
        /*
    ------------------------------------------------------------------------------   
       
    Коваріантність, контраваріантність та інваріантність
    
    
    Спочатку трохи теорії. 
    
    Коваріантність - це збереження ієрархії успадкування вихідних типів у похідних типах 
            у тому ж порядку. Наприклад, якщо Кіт - це підтип Тварини , то  Множина<Кіт> - це підтип Множина<Тварини> . 
            Отже, з урахуванням принципу підстановки можна виконати таке присвоєння:
    
                    Множина<Тварини> = Множина<Кіт>
                    
    Контраваріантність - це звернення ієрархії вихідних типів на протилежну у похідних типах. 
            Наприклад, якщо Кіт - це підтип Тварини, то Множина<Тварини> - це підтип Множина<Кіт> . 
            Отже, з урахуванням принципу підстановки можна виконати таке:
    
                    Множина<Кіт> = Множина<Тварини>          
    
    Інваріантність - відсутність успадкування між похідними типами. 
            Якщо Кіт - це підтип Тварини , то Множина<Кіт> не є підтипом Множина<Тварини> і Множина<Тварини> не є підтипом Множина<Кіт> .     
    
         */


        // Масиви в Java коваріантні. Тип S[] є підтипом T[], якщо Sп ідтип T. Приклад присвоєння:
        String[] strings = new String[]{"a", "b", "c"};
        Object[] arr = strings;

//        arr[0] = 42; // Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
        
        /*
        Але якщо спробуємо змінити вміст масиву через змінну arr і запишемо туди число 42, то отримаємо 
            ArrayStoreException на етапі виконання програми, оскільки 42 не є рядком, а числом. 
            У цьому проблема Коваріантності масивів Java: ми не можемо виконати перевірки на етапі компіляції, і щось може зламатися вже в рантаймі.   
    
         */


//        "Дженерики" інваріантні:
        List<Integer> ints = Arrays.asList(1, 2, 3);
//        List<Number> nums = ints; // compile-time error.  java: incompatible types: java.util.List<java.lang.Integer> cannot be converted to java.util.List<java.lang.Number>
//        nums.set(2, 3.14);
        assert ints.toString().equals("[1, 2, 3.14]");
        
        /*
        Якщо взяти список цілих чисел, він не буде ні підтипом типу Number, ні будь-яким іншим підтипом. 
        Він є лише підтипом самого себе. Тобто List <Integer>це List<Integer>і нічого більше. 
        Компілятор подбає про те, щоб змінна ints, оголошена як список об'єктів класу Integer, 
        містила лише об'єкти класу Integer і нічого, крім них. На етапі компіляції проводиться перевірка, і в рантаймі вже нічого не впаде.
         */


        /*
        Символи підстановки

        Чи завжди Generics інваріанти? Ні.

                Коваріантність = List<Integer>- ПідтипList<? extends Number>
         */

        List<Integer> ints1 = new ArrayList<Integer>();
        List<? extends Number> nums1 = ints1;
        
        
        /*
         Це контраваріантність. List<Number>є підтипом List<? super Integer>.  
         */
        List<Number> nums2 = new ArrayList<Number>();
        List<? super Integer> ints2 = nums2;
        
        
        /*
        Запис виду "? extends ..."або "? super ..."- називається wildcard або символом підстановки, 
        з верхнім кордоном (extends) або з нижнім кордоном (super). 
        
        List<? extends Number> може містити об'єкти, клас яких є Number або ті, що успадковується від Number (тобто Number і його підтипи). 
        List<? super Number> може містити об'єкти, клас яких Number або тип, у якого Number є спадкоємцем (тобто Number і супертип від Number).
        
         */
        
        
        /*
                            READ ONY - WRITE ONLY
                            
                            
        
        Якщо контейнер оголошений з wildcard ? extends, його можна лише читати значення. 
   
         До списку не можна нічого додати, окрім null. 
         Для того, щоб додати об'єкт до списку, нам потрібен інший тип wildcard. ? super     
         */

        List<Integer> ints3 = new ArrayList<Integer>();
        ints3.add(1);
        ints3.add(2);
        List<? extends Number> nums3 = ints3;
//        nums3.add(3.14); // compile-time error
        
        /*
        Не можна прочитати елемент із контейнера з wildcard ? super, крім об'єкта класу Object
        
                    public static <T> T getFirst(List<? super T> list) {
                        return list.get(0); // compile-time error
                    }
                    
       тут буде ок, бо Object   
                    public static <T> Object getFirst(List<? super T> list) {
                       return list.get(0);
                    }
         */
        
    /*
       Особливість wildcard з верхньою та нижньою межами дає додаткові фічі, пов'язані з безпечним використанням типів. 
        З одного типу змінних можна лише читати, в інший - тільки записувати 
        (виключенням є можливість записати null для extends і прочитати Object для super). 
   
        Щоб було легше запам'ятати, коли якусь wildcard використовувати, існує принцип PECS — Producer Extends Consumer Super.
   
        Якщо ми оголосили wildcard з extends, то це producer. Він лише «продюсує», надає елемент із контейнера, а сам нічого не приймає.
        Якщо ж ми оголосили wildcard з super - це consumer. Він лише приймає, а надати нічого не може.       
     */
        
        /*
         <?> і Raw типи
  
        Нижче наведено wildcard з необмеженим символом підстановки. Ми просто ставимо <?>без ключових слів super або extends:
                static void printCollection(Collection<?> c) {
                       // a wildcard collection
                       for (Object o : c) {
                           System.out.println(o);
                       }
                    }
                    
        Насправді такий «необмежений» wildcard все-таки обмежений зверху. Collection<?> - Це теж символ підстановки, 
        як і " ? extends Object". Запис виду Collection<?>рівносильний Collection<? extends Object> , 
        а значить - колекція може містити об'єкти будь-якого класу, так як всі класи в Java успадковуються від Object- 
        тому підстановка називається необмеженою.    
         */

        ArrayList<String> strings2 = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList = strings2; // Ok
        strings2 = arrayList; // Unchecked assignment
        arrayList.add(1); //unchecked call


        /*
        
            Захоплення підстановок
         
                    // Помилка!
                    public static void reverse(List<?> list) {
                        List<Object> tmp = new ArrayList<Object>(list);
                        for (int i = 0; i < list.size(); i++) {
                            list.set(i, tmp.get(list.size()-i-1)); // compile-time error
                        }
                    }
                    
           Помилка компіляції виникла, тому що методом reverse як аргумент приймається список з необмеженим символом підстановки <?> .
           <?> означає те, що і <? extends Object>. Отже, згідно з принципом PECS, list це producer. 
           А producer лише продюсує елементи. А ми у циклі for викликаємо метод set(), тобто намагаємося записати у list. 
           І тому спираємося на захист Java, що не дозволяє встановити якесь значення за індексом.
           
        
         */
        
        
        /*
        Що робити? Нам допоможе патерн Wildcard Capture. Тут ми створюємо узагальнений метод rev. 
           Він оголошений зі змінною типу T. Цей метод приймає список типів T і ми можемо зробити сет.
           
                           public static void reverse(List<?> list) { 
                             rev(list); 
                           }
                           
                           private static <T> void rev(List<T> list) {
                             List<T> tmp = new ArrayList<T>(list);
                             for (int i = 0; i < list.size(); i++) {
                               list.set(i, tmp.get(list.size()-i-1));
                             }
                           }
                           
           Тепер у нас все скомпілюється. Тут відбулося захоплення символу підстановки (wildcard capture). 
           При виклику методу reverse(List<?> list)як аргумент передається список якихось об'єктів (наприклад, рядків чи цілих чисел). 
           Якщо ми можемо захопити тип цих об'єктів і привласнити його змінної типу X, можемо укласти, T що X.
    
                    
         */
        
        
        /*
        Висновок
  
          Якщо необхідно читати з контейнера, то використовуйте wildcard з верхнім кордоном "? extends". 
          Якщо потрібно писати в контейнер, то використовуйте wildcard з нижньою межею "? super". 
          
          Не використовуйте wildcard, якщо потрібно робити і запис, і читання.
          
          Не використовуйте Raw типи! Якщо аргумент типу не визначено, використовуйте wildcard <?>.        
          
         */
        
        
        /*
        Змінні типу
  
           Коли ми записуємо при оголошенні класу або методу ідентифікатор у кутових дужках, наприклад , 
           <T> або <E> створюємо змінну типу. Змінна типу — це некваліфікований ідентифікатор, який можна використовувати 
           як тип у тілі класу чи методу. Змінна тип може бути обмежена зверху.
           
                        public static <T extends Comparable<T>> T max(Collection<T> coll) {
                          T candidate = coll.iterator().next();
                          for (T elt : coll) {
                            if (candidate.compareTo(elt) < 0) candidate = elt;
                          }
                          return candidate;
                        }
                        
           У цьому вся прикладі вираз T extends Comparable<T> визначає T(змінну типу), обмежену зверху типом Comparable<T>. 
           На відміну від wildcard, змінні типу можуть бути обмежені тільки зверху (тільки extends). 
           Не можна записати super. Крім того, у цьому прикладі T залежить від самого себе, це називається recursive bound рекурсивний кордон.             
           
         */

    }

    // Не можна прочитати елемент із контейнера з wildcard ? super, крім об'єкта класу Object
    public static <T> T getFirst(List<? super T> list) {
        return list.get(0); // compile-time error
    }

    // тут буде ок, бо Object   
    public static <T> Object getFirst2(List<? super T> list) {
        return list.get(0);
    }

    // Нижче наведено wildcard з необмеженим символом підстановки. Ми просто ставимо <?>без ключових слів super або extends:
    static void printCollection(Collection<?> c) {
        // a wildcard collection
        for (Object o : c) {
            System.out.println(o);
        }
    }

    // Помилка!
    public static void reverse(List<?> list) {
        List<Object> tmp = new ArrayList<Object>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1)); // compile-time error
        }
    }


    public static void reverse2(List<?> list) {
        rev(list);
    }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }

    /*
     Змінні типу
     
 
     Коли ми записуємо при оголошенні класу або методу ідентифікатор у кутових дужках, наприклад ,
     <T> або <E> створюємо змінну типу. Змінна типу — це некваліфікований ідентифікатор, який можна використовувати
     як тип у тілі класу чи методу. Змінна тип може бути обмежена зверху.
    */
    public static <T extends Comparable<T>> T max(Collection<T> coll) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }
    /*
        У цьому прикладі вираз T extends Comparable<T> визначає T(змінну типу), обмежену зверху типом Comparable<T>.
        На відміну від wildcard, змінні типу можуть бути обмежені тільки зверху (тільки extends).
        Не можна записати super. Крім того, у цьому прикладі T залежить від самого себе, це називається recursive bound рекурсивний кордон.
    */
}
