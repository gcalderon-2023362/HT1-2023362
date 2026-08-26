/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gc.system.utils;

/**
 *
 * @author informatica
 */
public class Validations {

    public Validations() {

    }

    public Boolean equalsText(String textOriginal, String textCompare) {
        return textOriginal.equals(textCompare);

    }

    public Boolean emptyText(String text) {
        boolean isEmpty = true;

        if (text.isEmpty() || text.isBlank()) {
            isEmpty = true;
        }

        return isEmpty;
    }

    public Boolean validareLengthText(String text, int lengthMax) {
        return text.length() <= lengthMax;
    }

    public Boolean validateEmail(String email){
        
        return true;
    }
}
