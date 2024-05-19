import java.util.Scanner;
import java.security.SecureRandom;

public class JogoDaSenha {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int comprimento = 4;

        System.out.println("\n\n\tBEM-VINDO AO JOGO DA SENHA");

        String senha = gerarSenha(comprimento);
        System.out.println("\nSenha: " + senha); //depois deixar como comentário; serve como cola para testes
        String senhaEscondida = transformarSenha(senha, '*');
        System.out.println("ADIVINHE A SENHA: " + senhaEscondida);

        verificador(senha);
    }
    
    public static String gerarSenha(int comprimento) {
        
        String caracteres = "123456";
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        for (int i=0; i<comprimento; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }

    public static String transformarSenha(String senha2, char substituto) {

        StringBuilder senhaTransformada = new StringBuilder();
        for (int i=0; i<senha2.length(); i++) {
            senhaTransformada.append(substituto);
        }

        return senhaTransformada.toString();
    }

    public static void verificador(String senha){
        Scanner sc = new Scanner(System.in);
        int acertou=0;

        do{
            System.out.print("\nTENTATIVA: ");
            String tentativa = sc.next();

            if (tentativa.equals(senha)) {
                System.out.println("PARABÉNS!! VOCÊ ACERTOUU");
                break;
            } else {
                System.out.println("SENHA INCORRETA! TENTE NOVAMENTE.");
            }
        }while(acertou<11);
    }
}