package com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.service.impl;

import com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.dto.NameNumerologyDto;
import com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.service.NameNumerologyService;
import org.springframework.stereotype.Service;

@Service
public class NameNumerologyServiceImpl implements NameNumerologyService {

    @Override
    public NameNumerologyDto CalculateNumerologyNumber(String name) {

        NameNumerologyDto nm = new NameNumerologyDto();

        String nameClean = name.replaceAll("\\n","").replaceAll("\\r","");

        nm.setName(nameClean);
        nm.setVowels("");
        nm.setConsonants("");
        nm.setConsonants("");
        nm.setLifeGoalsNumber(0);
        nm.setInternalVibrationNumber(0);
        nm.setExternalVibrationNumber(0);

        for (int i = 0; i < nameClean.length(); i++) {

            String nameCharEnter = String.valueOf(nameClean.charAt(i));
            String nameChar = nameCharEnter.toLowerCase();

            //Calculate InternalVibrationNumber with
            switch (nameChar) {
                case "a":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 1);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 1);
                    nm.setVowels(nm.getVowels() + nameChar);
                    break;
                case "e":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 5);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 5);
                    nm.setVowels(nm.getVowels() + nameChar);
                    break;
                case "i":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 9);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 9);
                    nm.setVowels(nm.getVowels() + nameChar);
                    break;
                case "o":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 6);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 6);
                    nm.setVowels(nm.getVowels() + nameChar);
                    break;
                case "u":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 3);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 3);
                    nm.setVowels(nm.getVowels() + nameChar);
                    break;
                case "j":  case "s":
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 1);
                    nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 1);
                    nm.setConsonants(nm.getConsonants() + nameChar);
                    break;
                case "b":  case "k": case "t":
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 2);
                    nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 2);
                    nm.setConsonants(nm.getConsonants() + nameChar);
                    break;
                case "c":  case "l":
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 3);
                    nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 3);
                    nm.setConsonants(nm.getConsonants() + nameChar);
                    break;
                case "d":  case "m": case "v":
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 4);
                    nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 4);
                    nm.setConsonants(nm.getConsonants() + nameChar);
                    break;
                case "n":  case "w": case "ñ":
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 5);
                    nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 5);
                    nm.setConsonants(nm.getConsonants() + nameChar);
                    break;
                case "f":  case "x":
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 6);
                    nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 6);
                    nm.setConsonants(nm.getConsonants() + nameChar);
                    break;
                case "g":  case "p": case "y":
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 7);
                    nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 7);
                    nm.setConsonants(nm.getConsonants() + nameChar);
                    break;
                case "h":  case "q": case "z":
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 8);
                    nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 8);
                    nm.setConsonants(nm.getConsonants() + nameChar);
                    break;
                case "r":
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 9);
                    nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 9);
                    nm.setConsonants(nm.getConsonants() + nameChar);
                    break;
            }
        }
        //Plus digits of number when is mora than 1
        if (nm.getLifeGoalsNumber() >= 10) {
            Integer numerologyNumber = calculateOneDigit(nm.getLifeGoalsNumber());
            nm.setLifeGoalsNumber(numerologyNumber);
        }
        if (nm.getInternalVibrationNumber() >= 10) {
            Integer numerologyNumber = calculateOneDigit(nm.getInternalVibrationNumber());
            nm.setInternalVibrationNumber(numerologyNumber);

        }
        if (nm.getExternalVibrationNumber() >= 10) {
            Integer numerologyNumber = calculateOneDigit(nm.getExternalVibrationNumber());
            nm.setExternalVibrationNumber(numerologyNumber);
        }
        return nm;
    }
    //Function calculate 1 digit when is mora than 1
    public Integer calculateOneDigit(Integer numberEntered) {
        int suma = 0;
        int size = (Integer.toString(numberEntered)).length();
        for (int i = 0; i < size; i++) {
            String number = String.valueOf(Integer.toString(numberEntered).charAt(i));
            suma += Integer.parseInt(number);
        }
        if (suma >= 10) {
            suma = calculateOneDigit(suma);
        }
        return suma;
    }
}
