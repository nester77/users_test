package test_IG.validators;

import test_IG.entity.Roles;


import static java.lang.Integer.parseInt;
import static test_IG.entity.Roles.*;

public class Validators {

    public static boolean RolesValidator(Roles[] roles) {

        if (    roles[0]==roles[1]                         ||
                roles[0]!=EMPTY && roles[1]==SUPER_ADMIN   ||
                roles[1]!=EMPTY && roles[0]==SUPER_ADMIN   ||
                roles[0]==USER  && roles[1]==CUSTOMER      ||
                roles[1]==USER  && roles[0]==CUSTOMER      ||
                roles[0]==ADMIN && roles[1]==PROVIDER      ||
                roles[1]==ADMIN && roles[0]==PROVIDER

        ) {
            System.out.println("Неверное количество или сочетание ролей");
            return false;
        }

        else {
            return true;
        }
    }


    public static boolean EmailValidator(String email) {
        if (    email.indexOf("@")<1                        ||
                (email.indexOf(".")-email.indexOf("@"))<3   ||
                (email.length()-email.indexOf("."))<3

        ) {
            System.out.print("Неверный формат email! Введите еще раз: ");
            return false;
        }

        else return true;
    }


    public static boolean MobilePhoneValidator(String mobilePhone) {

        try {
            Long.parseLong(mobilePhone);

        } catch (NumberFormatException e){
            System.out.print("Неверный формат номера телефона! Введите еще раз: ");
            return false;
        }
        if (mobilePhone.equals("0")) return true;

        if (
                 mobilePhone.length()!=12        ||
                !mobilePhone.startsWith("375")


        ) {
            System.out.print("Неверный формат номера телефона! Введите еще раз: ");
            return false;
        }

        else return true;
    }


    public static boolean MobilePhonesValidator(String[] mobilePhones) {

        if (    mobilePhones[0].equals("0") &&
                mobilePhones[1].equals("0") &&
                mobilePhones[2].equals("0")

        ) {
            System.out.print("Введите хотя бы один номер телефона!");
            return false;
        }

        else return true;
    }


}
