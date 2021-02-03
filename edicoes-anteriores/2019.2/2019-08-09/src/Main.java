import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.print("Digite uma expressão: ");
        Parser parse = null;
        try {
            parse = new Parser();
            parse.expr();
            System.out.print('\n');

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static class Parser {
        static char lookahead;

        public Parser() throws IOException {
            lookahead = (char) System.in.read();
        }

        //expr -> term rest
        void expr() throws IOException {
            term();
            rest();
        }

        //rest -> + term {print('+')} rest
        //rest -> - term {print('-')} rest
        //rest -> EPSILON
        void rest() throws IOException {
            if (lookahead == '+') {
                match('+');
                term();
                System.out.print('+');
                System.out.print(' ');
                rest();
            } else if (lookahead == '-') {
                match('-');
                term();
                System.out.print('-');
                System.out.print(' ');
                rest();
            } else {
            }
        }

        void term() throws IOException {
            char t = lookahead;
            if (Character.isDigit(t)) {
                match(lookahead);
                System.out.print(t);
                System.out.print(' ');
            }
        }

        void match(char t) throws IOException {
            if (lookahead == t) {
                lookahead = (char) System.in.read();
            } else {
                throw new RuntimeException("Erro de sintaxe");
            }
        }
    }
}
