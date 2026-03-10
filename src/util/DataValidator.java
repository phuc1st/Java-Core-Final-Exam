package util;

import CustomException.InvalidDOBException;
import CustomException.InvalidFullNameException;
import CustomException.InvalidPhoneNumberException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class DataValidator {
    private static final String PHONE_REGEX = "^(090|098|091|031|035|038)\\d{7}$";

    public static void validateFullName(String fullName) throws InvalidFullNameException {
        if (fullName == null || fullName.trim().length() < 10 || fullName.trim().length() > 50) {
            throw new InvalidFullNameException("Họ và tên không hợp lệ nhé: " + fullName);
        }
    }

    public static void validateDOB(String dob) throws InvalidDOBException {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        sf.setLenient(false);
        try {
            sf.parse(dob);
        } catch (ParseException e) {
            throw new InvalidDOBException("Ngày sinh không đúng định dạng(dd/MM/yyyy): " + dob);
        }
    }

    public static void validatePhone(String phoneNumber) throws InvalidPhoneNumberException {
        if (!Pattern.matches(PHONE_REGEX, phoneNumber)) {
            throw new InvalidPhoneNumberException("Số điện thoại sai định dạng: " + phoneNumber);
        }
    }
}
