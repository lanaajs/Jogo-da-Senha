import java.util.Scanner;
import java.security.SecureRandom;

public class JogoDaSenha {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int comprimento = 4;

        System.out.println("\n\n\tBEM-VINDO AO JOGO DA SENHA");

        String senha = gerarSenha(comprimento);
        System.out.println("\nSenha: " + senha); //esconder durante o jogo

        char[] senhaVetor = senha.toCharArray();
        String senhaEscondida = transformarSenha(senha, '*');

        System.out.println("ADIVINHE A SENHA: " + senhaEscondida);

        verificador(senhaVetor);
    }
    
    public static String gerarSenha(int comprimento) {
        String caracteres = "123456";
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }

    public static String transformarSenha(String senha, char substituto) {
        StringBuilder senhaTransformada = new StringBuilder();
        
        for (int i = 0; i < senha.length(); i++) {
            senhaTransformada.append(substituto);
        }

        return senhaTransformada.toString();
    }

    public static void verificador(char[] senha) {
        Scanner sc = new Scanner(System.in);
        
        int ponto = 10;
    
        do {
            
            int contCorretos = 0;
            int contDigitosPosicaoErrada = 0;
        
            System.out.print("\nTENTATIVA: ");
            String tentativa = sc.next();
    
            for (int i = 0; i < senha.length; i++) {
                if (senha[i] == tentativa.charAt(i)) {
                    contCorretos++;
                } else {
                    for (int j = 0; j < senha.length; j++) {
                        if (senha[j] == tentativa.charAt(i)) {
                            contDigitosPosicaoErrada++;
                            break;
                        }
                    }
                }
            }
    
            System.out.println("\nDIGITO CORRETO NA POSIÇÃO CORRETA: " + contCorretos);
            System.out.println("DIGITO CORRETO NA POSIÇÃO ERRADA: " + contDigitosPosicaoErrada);
            
            if (contCorretos == senha.length) {
                System.out.println("\nPARABÉNS!! VOCÊ ACERTOU!");
                break;
            }
    
            ponto--;
            System.out.println("CHANCES RESTANTES: " + ponto);
    
            if (ponto == 0) {
                System.out.println("\nSENHA INCORRETA! VOCÊ PERDEU TODAS AS SUAS CHANCES :(");
                break;
            }
    
        } while (true);
    }
    
}
