package view;

import java.util.*;

import static view.Text.*;

public class RegistryUI implements InputUI {
    private Scanner scan = new Scanner(System.in);

    public String getUserStr() {
        return scan.nextLine();
    }
    public String getUserStr2() {
        scan.nextLine();
        return scan.nextLine();
    }

    public void textOnConsole(Text key) {
        Map<Text, String> textMap = Map.of(
                HELLO, "### Добро пожаловать в программу \"Реестр домашних животных\"! ###\n",
                ADDTYPE, "Введите первый символ соответствующий типу добавляемого животного\n(например," +
                        " для лошади нужно ввести символ 'л', для хомяка - 'х') >>> ",
                ADDNAME, "\nВведите кличку животного >>> ",
                ADDBDAY, "\nВведите дату рождения животного в формате ГГГГ-ММ-ДД >>> ",
                ADDCOMM, "\nВведите новую команду изученную животным >>> ",
                COMMANDS, "Введите кличку животного, чтобы узнать какие команды оно умеет выполнять >>> ",
                ACTION, "Нажмите клавишу '1', чтобы добавить новое животное в реестр" +
                        "\nНажмите клавишу '2', чтобы вывести список животных, отсортированный по дате рождения" +
                        "\nНажмите клавишу '3', чтобы узнать какие команды умеют выполнять животные из реестра" +
                        "\nНажмите клавишу '4', чтобы добавить животному новую изученную команду" +
                        "\nНажмите клавишу '5', чтобы узнать сколько всего животных было добавлено в реестр" +
                        "\nНажмите клавишу 'q' для выхода из программы \nВыберите действие >>> ",
                BYE, "\nСпасибо за пользование реестром!");
        System.out.print(textMap.get(key));
    }

    @Override
    public char getAction() {
        Set<Character> operators = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', 'q'));
        char res = ' ';
        while (!operators.contains(res)) {
            textOnConsole(ACTION);
            res = scan.next().charAt(0);
        }
        return res;
    }

    @Override
    public void closeScanner() {
        scan.close();
    }

    public char getType() {
        Set<Character> operators = new HashSet<>(Arrays.asList('к', 'с', 'х', 'л', 'о', 'в'));
        char res = ' ';
        while (!operators.contains(res)) {
            textOnConsole(ADDTYPE);
            res = scan.next().charAt(0);
        }
        return res;
    }
}
