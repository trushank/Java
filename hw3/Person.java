import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
class Person {
    private String givenName;
    private String familyName;
    private String ssn;
    private int birth_day;
    private int birth_month;
    private int birth_year;
    public Person() {
        Scanner src = new Scanner(System. in );
        System.out.println("Enter the given name");
        set_givenName(src.nextLine());
        System.out.println("Enter the family name");
        set_familyName(src.nextLine());
        System.out.println("Enter the ssn no");
        while (!set_ssn(src.nextLine()));
        int d = 0, m = 0, y = 0; //temp variables to store date
        do {
            System.out.println("Enter the Birth Month");
            m = src.nextInt();
            src.nextLine();
            System.out.println("Enter the Birth Date");
            d = src.nextInt();
            src.nextLine();
            System.out.println("Enter the Birth Year");
            y = src.nextInt();
            src.nextLine();
        } while (!set_dateOfBirth(m, d, y));
        
    }
    public Person(String givenName, String familyName, String ssn, int birth_day, int birth_month, int birth_year) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.ssn = ssn;
        this.birth_day = birth_day;
        this.birth_month = birth_month;
        this.birth_year = birth_year;
    }
    public int get_birth_day() {
        return birth_day;
    }
    public int get_birth_month() {
        return birth_month;
    }
    public int get_birth_year() {
        return birth_year;
    }
    public String get_ssn() {
        return ssn;
    }
    public String get_givenName() {
        return givenName;
    }
    public String get_familyName() {
        return familyName;
    }
    public boolean set_dateOfBirth(int newMonth, int newDay, int newYear) {
        if (checkMaxDays(newMonth, newYear) >= newDay && checkMaxDays(newMonth, newYear) != -1) {
            if (newMonth <= 12 && newYear >= 1900) {
                birth_day = newDay;
                birth_month = newMonth;
                birth_year = newYear;
                return true;
            }
        }
        System.out.println("Error in Date. Try again");
        return false;
    }
    public boolean set_ssn(String newSsn) {
        if (newSsn.length() == 9) {
            try {
                Integer.parseInt(newSsn);
            } catch (NumberFormatException e) {
                return false;
            }
            ssn = newSsn;
            return true;
        }
        System.out.println("Wrong SSN Entered. Try Again.");
        return false;
    }
    public boolean set_familyName(String new_family_Name) {
        familyName = new_family_Name;
        return true;
    }
    public boolean set_givenName(String new_givenName) {
        givenName = new_givenName;
        return true;
    }
    public int calc_Age() {
        int age;
        Date todaysDate = new java.util.Date();
        String formattedDate = new SimpleDateFormat("dd").format(todaysDate);
        String formattedMonth = new SimpleDateFormat("MM").format(todaysDate);
        String formattedYear = new SimpleDateFormat("yyyy").format(todaysDate);
        if (birth_month > Integer.parseInt(formattedMonth) && birth_day > Integer.parseInt(formattedDate)) age = Integer.parseInt(formattedYear) - birth_year - 1;
        else age = Integer.parseInt(formattedYear) - birth_year;
        return age;
    }
    public void vote_check() {
        if (calc_Age() >= 18) System.out.println("You can vote");
        else System.out.println("You can not vote");
    }
    public void senior_check() {
        if (calc_Age() >= 65) System.out.println("You are a senior citizen");
        else System.out.println("You are not a senior citizen");
    }
    public int checkMaxDays(int month, int year) {
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 2:
            if (year % 4 == 0) return 29;
            else return 28;
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
        default:
            return -1;
        }
    }
    public void display() {
        Scanner src = new Scanner(System. in );
        while (true) {
            System.out.println("\n\n1:Calculate the age");
            System.out.println("2:Can vote?");
            System.out.println("3:Is a senior citizen?");
            System.out.println("4: Check Equality");
            System.out.println("5:Exit");
            System.out.println("Enter your choice");
            switch (Integer.parseInt(src.nextLine())) {
            case 1:
                System.out.println("The age is " + calc_Age());
                break;
            case 2:
                vote_check();
                break;
            case 3:
                senior_check();
                break;
            case 4:
                Person p1 = new Person();
                if (p1.get_ssn() == get_ssn()) //since ssn is a unique field
                System.out.println("Duplicate Entry Detected");
                else System.out.println("Unique Entires");
                break;
            case 5:
                System.out.println("Exitting Program");
                return;
            default:
                System.out.println("Not an option");
                break;
            }
        }
    }
}