package coffee;

import java.util.ArrayList;

/**
 * Класс реализует кофе машину.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CoffeeMachine {

    /**
     * Константы представляющие монеты для сдачи в кофе машине.
     */
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int FIVE = 5;
    public static final int TEN = 10;

    /**
     * Отсортированный массив монет для сдачи.
     */
    int[] coinsSort = new int[]{TEN, FIVE, TWO, ONE};

    /**
     * Метод реализует работу кофе машину.
     *
     * @param value Номинал купюры, которую вставил клиент.
     * @param price - Цена кофе.
     * @throws SmallBillException Если цена выше, вставленной купюры.
     * @return Возвращает массив монет сдачи. Количество монет в сдаче минимально.
     */
    public int[] changes(int value, int price) {
        int change = value - price;
        ArrayList<Integer> result = new ArrayList<>();
        int changeCounter = 0;
        if (change == 0) {
            result.add(0);
        } else if (change < 0) {
            throw new SmallBillException("Too little money!");
        } else {
            for (int i = 0; i < coinsSort.length; i++) {
                int coin = coinsSort[i];
                while (changeCounter <= change) {
                    if (changeCounter + coin <= change) {
                        result.add(coin);
                        changeCounter += coin;
                    } else {
                        break;
                    }
                }
            }
        }
        return listToArray(result);
    }

    /**
     * Метод конвертирует ArrayList в массив.
     *
     * @param list ArrayList, который нужно конвертировать.
     * @return Масив полученный из элементов переданного в метод ArrayList'а.
     */
    public int[] listToArray(ArrayList<Integer> list) {
        int[] resultArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }
}