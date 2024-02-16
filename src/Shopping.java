import java.util.Arrays;
import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");
        String[] shoppingList = new String[8];
        Scanner scanner = new Scanner(System.in);
        int productCount = 0;
        int productInList;

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();
            if (actionNumber == 1) {
                boolean itemInShoppingList = true;
                System.out.println("Введите название товара");
                scanner.nextLine();
                String itemName = scanner.nextLine();
                for (String item : shoppingList) {
                    if (itemName.equals(item)) {
                        itemInShoppingList = false;
                        System.out.println("Такой товар уже есть в списке");
                        break;
                    }
                }
                if ((productCount < shoppingList.length) && (itemInShoppingList)) {
                    productCount++;
                    shoppingList[productCount - 1] = itemName;
                    System.out.println("В список продуктов добавлен " + itemName);
                } else if (itemInShoppingList) {
                    productCount++;
                    String[] shoppingListCopy = new String[productCount];
                    System.arraycopy(shoppingList, 0, shoppingListCopy, 0, shoppingList.length);
                    shoppingListCopy[productCount - 1] = itemName;
                    shoppingList = shoppingListCopy;
                    System.out.println("В список продуктов добавлен " + itemName);
                }
            } else if (actionNumber == 2) {
                productInList = 1;
                if (productCount == 0) {
                    System.out.println("Список товаров пуст");
                } else {
                    System.out.println("Сейчас в списке следующие товары:");
                    for (int j = 0; j < productCount; j++) {
                        System.out.println("Товар №" + productInList + " - " + shoppingList[j]);
                        productInList++;
                    }
                }
            } else if (actionNumber == 3) {
                Arrays.fill(shoppingList, null);
                productCount = 0;
                System.out.println("Список очищен");
            } else if (actionNumber == 4) {
                System.out.println("Работы программы завершена");
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }

    }
}
