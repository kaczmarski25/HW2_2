package geekbrains_home_work;

public class Main {

    public static void main(String[] args) {
	String[][] numbers = {
            {"10", "11", "12", "13"},
            {"1", "2", "3", "4"},
            {"20","15","10","0"},
            {"1", "5", "y", "2"},

    };

    checkSize(numbers);

    try {
        System.out.println("Сумма введенных чисел массива " + calc(numbers));
    } catch (MyArrayDataException ex) {
        ex.printStackTrace();
    }
    }

    static int calc (String[][] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers[i].length; j++){
                try {
                    sum += Integer.parseInt((numbers[i][j]));
                }catch (NumberFormatException ex) {
                    throw  new MyArrayDataException ("В ячейке [" + (i + 1)  +"][" + (j + 1)  +"] имеется не верный формат ввода данных. Замените его на Integer", ex);
                }
            }
        }
        return sum;
    }

    static void checkSize(String[][] values) {
        if (values.length != 4) {
            throw new MyArraySizeException(String.format(" Проверьте колличество строк. Для нормальной работы, должно быть 4", values.length));
        }

    }
}
