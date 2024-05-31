import java.util.Scanner;
import java.security.SecureRandom;

public class JogoDaSenha {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int comprimento = 4;

        System.out.println("\n\n\tBEM-VINDO AO JOGO DA SENHA");

        String senha = gerarSenha(comprimento);
        System.out.println("\nSenha: " + senha); //depois deixar como comentário; serve como cola para testes
        char[] senhaVetor = senha.toCharArray();
        String senhaEscondida = transformarSenha(senha, '*');
        System.out.println("ADIVINHE A SENHA: " + senhaEscondida);

        verificador(senhaVetor);
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

    public static String transformarSenha(String senha, char substituto) {

        StringBuilder senhaTransformada = new StringBuilder();
        for (int i=0; i<senha.length(); i++) {
            senhaTransformada.append(substituto);
        }

        return senhaTransformada.toString();
    }

    public static void verificador(char[] senha){
        Scanner sc = new Scanner(System.in);
        int acertou=0;

        do{
            System.out.print("\nTENTATIVA: ");
            String tentativa = sc.next();

            if (tentativa.equals(String.valueOf(senha))) {
                System.out.println("PARABÉNS!! VOCÊ ACERTOUU");
                break;
            } else {
                 // Verificar se os números estão na senha e se estão na posição correta ou errada
                 for (int i = 0; i < senha.length; i++) {
                    if (tentativa.charAt(i) == senha[i]) {
                        System.out.println(" está na posição correta.");
                    } else if (String.valueOf(senha).contains(String.valueOf(tentativa.charAt(i)))) {
                        System.out.println(" está na senha, mas na posição errada.");
                    } else {
                        System.out.println(" não está na senha.");
                    }

                //System.out.println("SENHA INCORRETA! TENTE NOVAMENTE.");
                }
            }
        }while(acertou<11);
    }
}
