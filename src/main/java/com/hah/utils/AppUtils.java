package com.hah.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.text.Normalizer;
import java.util.*;


@Component
public class AppUtils {

    public ResponseEntity<?> mapErrorToResponse(BindingResult result) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
//            if (fieldError.getField().equals("file")){
//                errors.put(fieldError.getField(), "File upload is invalid!");
//                continue;
//            }
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    public String getUsernamePrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }

        return userName;
    }


    public String replaceNonEnglishChar(String str) {
        str = str.toLowerCase();
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("đ", "d");
        str = str.replaceAll("[^\\x00-\\x7F]", "");

        return str;
    }

    public String removeNonAlphanumeric(String str) {
        do {
            str = str.replace(" ","-");
            str = str.replaceAll("[^a-zA-Z0-9\\-]", "-");
            str = str.replaceAll("--", "-");

            while (str.charAt(0) == '-') {
                str = str.substring(1);
            }

            while (str.charAt(str.length() - 1) == '-') {
                str = str.substring(0, str.length() - 1);
            }
        }
        while (str.contains("--"));

        return str.trim().toLowerCase(Locale.ENGLISH);
    }

    public LinkedHashSet<String> removeDuplicates(List<String> arr) {
        LinkedHashSet<String> newArr = new LinkedHashSet<String>();

        for (int i = 0; i < arr.size(); i++) {
            newArr.add(arr.get(i));
        }
        return newArr;
    }

    public String convertToTitle(String[] arr) {
        StringBuilder strTitle = new StringBuilder();
        int length = 7;

        for (int i = 1;i < length;i++) {
            int indexValue = arr[i].indexOf("\"");
            arr[i] = arr[i].substring(0,indexValue-1);

            if (i != length - 1) {
                int indexValue1 = arr[i].indexOf(",");
                arr[i] = arr[i].substring(0,indexValue1);
                strTitle.append(arr[i].trim()).append("/ ");
            }
            else {
                int indexValue1 = arr[i].indexOf(",");
                arr[i] = arr[i].substring(0,indexValue1);
                strTitle.append(arr[i].trim());
            }
        }

        return strTitle.toString();
    }

}
