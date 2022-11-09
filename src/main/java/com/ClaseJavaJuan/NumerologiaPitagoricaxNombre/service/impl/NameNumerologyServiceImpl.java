package com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.service.impl;

import com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.dto.NameNumerologyDto;
import com.ClaseJavaJuan.NumerologiaPitagoricaxNombre.service.NameNumerologyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameNumerologyServiceImpl implements NameNumerologyService {

    @Override
    public NameNumerologyDto CalculateNumerologyNumber(String name) {
        NameNumerologyDto nm = new NameNumerologyDto();
        nm.setName(name);
        nm.setVowels("");
        nm.setConsonants("");
        nm.setLifeGoalsNumber(0);
        nm.setInternalVibrationNumber(0);
        nm.setExternalVibrationNumber(0);

        for (int i = 0; i < name.length(); i++) {

            String nameCharMinusculasMayusculas = String.valueOf(name.charAt(i));
            String nameChar = nameCharMinusculasMayusculas.toLowerCase();

            //Para hallar InternalVibrationNumber desde las vocales
            switch (nameChar) {
                case "a":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 1);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 1);
                    break;
                case "e":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 5);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 5);
                    break;
                case "i":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 9);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 9);
                    break;
                case "o":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 6);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 6);
                    break;
                case "u":
                    nm.setInternalVibrationNumber(nm.getInternalVibrationNumber() + 3);
                    nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 3);
                    break;
            }

            //Para hallar ExternalVibrationNumber desde las consonantes
            if (nameChar.equals("j") || nameChar.equals("s")) {
                nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 1);
                nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 1);
            } else if (nameChar.equals("b") || nameChar.equals("k") || nameChar.equals("t")) {
                nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 2);
                nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 2);
            } else if (nameChar.equals("c") || nameChar.equals("l")) {
                nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 3);
                nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 3);
            } else if (nameChar.equals("d") || nameChar.equals("m") || nameChar.equals("v")) {
                nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 4);
                nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 4);
            } else if (nameChar.equals("n") || nameChar.equals("w") || nameChar.equals("ñ")) {
                nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 5);
                nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 5);
            } else if (nameChar.equals("f") || nameChar.equals("x")) {
                nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 6);
                nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 6);
            } else if (nameChar.equals("g") || nameChar.equals("p") || nameChar.equals("y")) {
                nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 7);
                nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 7);
            } else if (nameChar.equals("h") || nameChar.equals("q") || nameChar.equals("z")) {
                nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 8);
                nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 8);
            } else if (nameChar.equals("r")) {
                nm.setLifeGoalsNumber(nm.getLifeGoalsNumber() + 9);
                nm.setExternalVibrationNumber(nm.getExternalVibrationNumber() + 9);
            }
        }
        //Para sumar los digitos del entero (cuando supera 2 digitos)
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

    //Funcion que suma los digitos
    public Integer calculateOneDigit(Integer numbertoCalculate) {
        Integer suma = 0;
        Integer size = Integer.toString(numbertoCalculate).length();
            for (int i = 0; i < size; i++) {
                String digit = String.valueOf(Integer.toString(numbertoCalculate).charAt(i));
                suma += Integer.parseInt(digit);
        }
        return suma;
    }
}

/*
        public Integer calculateOneDigit (Integer numberCalculate){
            Integer sumaIVN = 0;
            Integer sizeIVN = Integer.toString(nm.getInternalVibrationNumber()).length();

            if (nm.getInternalVibrationNumber() >= 10) {

                for (int iIVN = 0; iIVN < sizeIVN; iIVN++) {
                    String stringNumberIVN = Integer.toString(nm.getInternalVibrationNumber());
                    String numberIVN = String.valueOf(stringNumberIVN.charAt(iIVN));
                    //String numberIVN = String.valueOf(Integer.toString(nm.getInternalVibrationNumber()).charAt(iIVN));
                    sumaIVN += Integer.parseInt(numberIVN);
                }
                nm.setInternalVibrationNumber(sumaIVN);
            }
            return nm;
        }


 */