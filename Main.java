import functions.*;
import functions.basic.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("ТЕСТИРОВАНИЕ МЕТОДОВ");
        
        try {
            // Создаем тестовые данные
            FunctionPoint[] points1 = { new FunctionPoint(0, 0),new FunctionPoint(1, 1), new FunctionPoint(2, 4),new FunctionPoint(3, 9) };
            
            FunctionPoint[] points2 = { new FunctionPoint(0, 0),new FunctionPoint(1, 1),new FunctionPoint(2, 4),new FunctionPoint(3, 9) };
            
            FunctionPoint[] points3 = {new FunctionPoint(0, 0),new FunctionPoint(1, 2), new FunctionPoint(2, 4), new FunctionPoint(3, 9)};
            
            //ArrayTabulatedFunction
            System.out.println("\n Тестирование ArrayTabulatedFunction");
            ArrayTabulatedFunction arrayFunc1 = new ArrayTabulatedFunction(points1);
            ArrayTabulatedFunction arrayFunc2 = new ArrayTabulatedFunction(points2);
            ArrayTabulatedFunction arrayFunc3 = new ArrayTabulatedFunction(points3);
            //toString()
            System.out.println("arrayFunc1.toString(): " + arrayFunc1.toString());
            System.out.println("arrayFunc2.toString(): " + arrayFunc2.toString());
            System.out.println("arrayFunc3.toString(): " + arrayFunc3.toString());
            //equals()
            System.out.println("\n Тестирование equals()");
            System.out.println("arrayFunc1.equals(arrayFunc2): " + arrayFunc1.equals(arrayFunc2));
            System.out.println("arrayFunc1.equals(arrayFunc3): " + arrayFunc1.equals(arrayFunc3));
            System.out.println("arrayFunc1.equals(null): " + arrayFunc1.equals(null));
            System.out.println("arrayFunc1.equals(\"строка\"): " + arrayFunc1.equals("ыааауцс"));
            //hashCode()
            System.out.println("\n Тестирование hashCode()");
            System.out.println("arrayFunc1.hashCode(): " + arrayFunc1.hashCode());
            System.out.println("arrayFunc2.hashCode(): " + arrayFunc2.hashCode());
            System.out.println("arrayFunc3.hashCode(): " + arrayFunc3.hashCode());
            System.out.println("arrayFunc1.hashCode() == arrayFunc2.hashCode(): " + (arrayFunc1.hashCode() == arrayFunc2.hashCode()));
            //изменения объекта
            System.out.println("\n Тестирование изменения объекта");
            double originalY = arrayFunc1.getPointY(1);
            System.out.println("Исходный Y в точке 1: " + originalY);
            System.out.println("Исходный hashCode: " + arrayFunc1.hashCode());
            arrayFunc1.setPointY(1, originalY + 0.001);
            System.out.println("Измененный Y в точке 1: " + arrayFunc1.getPointY(1));
            System.out.println("Новый hashCode: " + arrayFunc1.hashCode());
            System.out.println("Хеш-коды различаются: " + (arrayFunc1.hashCode() != arrayFunc2.hashCode()));
            // Возвращаем исходное значение
            arrayFunc1.setPointY(1, originalY);
            //LinkedListTabulatedFunction
            System.out.println("\n Тестирование LinkedListTabulatedFunction");
            LinkedListTabulatedFunction linkedFunc1 = new LinkedListTabulatedFunction(points1);
            LinkedListTabulatedFunction linkedFunc2 = new LinkedListTabulatedFunction(points2);
            System.out.println("linkedFunc1.toString(): " + linkedFunc1.toString());
            System.out.println("linkedFunc2.toString(): " + linkedFunc2.toString());
            System.out.println("linkedFunc1.equals(linkedFunc2): " + linkedFunc1.equals(linkedFunc2));
            System.out.println("linkedFunc1.equals(linkedFunc1): " + linkedFunc1.equals(linkedFunc1));
            System.out.println("linkedFunc1.hashCode(): " + linkedFunc1.hashCode());
            System.out.println("linkedFunc2.hashCode(): " + linkedFunc2.hashCode());
            System.out.println("Согласованность equals/hashCode: " + (linkedFunc1.equals(linkedFunc2) == (linkedFunc1.hashCode() == linkedFunc2.hashCode())));
            // Тестирование сравнения между классами
            System.out.println("\n Тестирование сравнения между классами");
            System.out.println("arrayFunc1.equals(linkedFunc1): " + arrayFunc1.equals(linkedFunc1));
            System.out.println("linkedFunc1.equals(arrayFunc1): " + linkedFunc1.equals(arrayFunc1));
            System.out.println("arrayFunc1.hashCode(): " + arrayFunc1.hashCode());
            System.out.println("linkedFunc1.hashCode(): " + linkedFunc1.hashCode());
            System.out.println("Хеш-коды совпадают: " + (arrayFunc1.hashCode() == linkedFunc1.hashCode()));
            // Тестирование клонирования
            System.out.println("\n Тестирование глубокого клонирования");
            // ArrayTabulatedFunction
            System.out.println("\n ArrayTabulatedFunction");
            ArrayTabulatedFunction originalArray = new ArrayTabulatedFunction(points1);
            ArrayTabulatedFunction clonedArray = (ArrayTabulatedFunction) originalArray.clone();
            System.out.println("Оригинал (до изменения): " + originalArray.toString());
            System.out.println("Клон (до изменения): " + clonedArray.toString());
            // Изменяем оригинал
            try {
                originalArray.setPointY(1, 100);
                originalArray.setPointX(2, 2.5);
            } catch (InappropriateFunctionPointException e) {
                System.out.println("Ошибка при изменении точки: " + e.getMessage());
            }
            System.out.println("Оригинал (после изменения): " + originalArray.toString());
            System.out.println("Клон (после изменения оригинала): " + clonedArray.toString());
            System.out.println("Клон не изменился: " + (clonedArray.getPointY(1) == 1 && clonedArray.getPointX(2) == 2));
            // LinkedListTabulatedFunction
            System.out.println("\n LinkedListTabulatedFunction");
            LinkedListTabulatedFunction originalLinkedList = new LinkedListTabulatedFunction(points1);
            LinkedListTabulatedFunction clonedLinkedList = (LinkedListTabulatedFunction) originalLinkedList.clone();
            
            System.out.println("Оригинал (до изменения): " + originalLinkedList.toString());
            System.out.println("Клон (до изменения): " + clonedLinkedList.toString());
            // Изменяем оригинал
            try {
                originalLinkedList.setPointY(1, 200);
                originalLinkedList.setPointX(2, 3.5);
            } catch (InappropriateFunctionPointException e) {
                System.out.println("Ошибка при изменении точки: " + e.getMessage());
            }
            System.out.println("Оригинал (после изменения): " + originalLinkedList.toString());
            System.out.println("Клон (после изменения оригинала): " + clonedLinkedList.toString());
            System.out.println("Клон не изменился: " + (clonedLinkedList.getPointY(1) == 1 && clonedLinkedList.getPointX(2) == 2));
            // Проверка ссылочной независимости
            System.out.println("\n Проверка ссылочной независимости");
            System.out.println("originalArray == clonedArray: " + (originalArray == clonedArray));
            System.out.println("originalLinkedList == clonedLinkedList: " + (originalLinkedList == clonedLinkedList));
            System.out.println("originalArray.equals(clonedArray) после изменений: " + originalArray.equals(clonedArray));
            System.out.println("originalLinkedList.equals(clonedLinkedList) после изменений: " + originalLinkedList.equals(clonedLinkedList));
            // Дополнительная проверка FunctionPoint.clone()
            System.out.println("\n Проверка FunctionPoint.clone()");
            FunctionPoint originalPoint = new FunctionPoint(5, 10);
            FunctionPoint clonedPoint = (FunctionPoint) originalPoint.clone();
            System.out.println("Original point: " + originalPoint);
            System.out.println("Cloned point: " + clonedPoint);
            System.out.println("Points are equal: " + originalPoint.equals(clonedPoint));
            System.out.println("Points are same object: " + (originalPoint == clonedPoint));
            
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}