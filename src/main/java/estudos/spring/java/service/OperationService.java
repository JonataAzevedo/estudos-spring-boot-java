package estudos.spring.java.service;

import estudos.spring.java.exceptions.UnsupportedMethOperationException;
import org.springframework.stereotype.Service;

@Service
public class OperationService {


    public static Double covertToDouble(String strNumber) {
        if (strNumber == null) return 0d;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 1.0d;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Double soma(String numberOne, String numberTwo){

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMethOperationException("Please set a numeric value!");
        }

        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    public Double sub(String numberOne, String numberTwo){

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMethOperationException("Please set a numeric value!");
        }

        return covertToDouble(numberOne) - covertToDouble(numberTwo);
    }

    public Double mult(String numberOne, String numberTwo){

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMethOperationException("Please set a numeric value!");
        }

        return covertToDouble(numberOne) * covertToDouble(numberTwo);
    }

    public Double div(String numberOne, String numberTwo){

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMethOperationException("Please set a numeric value!");
        }

        return covertToDouble(numberOne) / covertToDouble(numberTwo);
    }

    public Double media(String numberOne, String numberTwo){

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMethOperationException("Please set a numeric value!");
        }

        return (covertToDouble(numberOne) + covertToDouble(numberTwo)) / 2;
    }

    public Double raiz(String number){

        if (!isNumeric(number)) {
            throw new UnsupportedMethOperationException("Please set a numeric value!");
        }

        return Math.sqrt(covertToDouble(number));
    }
}
