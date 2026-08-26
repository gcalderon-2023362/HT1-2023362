package org.gc.system.utils;

public class Validations {

    public Validations() {
    }

    public boolean equalsText(String textOriginal, String textCompare) {
        if (textOriginal == null || textCompare == null) {
            return false;
        }
        return textOriginal.equals(textCompare);
    }

    public boolean emptyText(String text) {
        // Si el texto es null, está vacío o solo contiene espacios, retornamos true (está vacío)
        if (text == null || text.isEmpty() || text.isBlank()) {
            return true;
        }
        // De lo contrario, retornamos false (NO está vacío)
        return false;
    }

    public boolean validareLengthText(String text, int lengthMax) {
        if (text == null) {
            return false;
        }
        return text.length() <= lengthMax;
    }

    public boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        int dotCount = 0;
        int arrobeCount = 0;

        // 1. Contamos cuántos '@' y '.' hay en total
        for (int index = 0; index < email.length(); index++) {
            char c = email.charAt(index);
            
            if (c == '.') {
                dotCount++;
            }
            if (c == '@') {
                arrobeCount++;
            }
        }
        
        // 2. Un email válido debe tener EXACTAMENTE un '@' y al menos un '.'
        if (arrobeCount != 1 || dotCount < 1) {
            return false;
        }
        
        // 3. Validación adicional: que no empiece o termine con '@'
        int atIndex = email.indexOf('@');
        if (atIndex == 0 || atIndex == email.length() - 1) {
            return false;
        }

        return true;