import java.util.Scanner;
import java.security.SecureRandom;

public class JogoDaSenha {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int comprimento = 4;

        System.out.println("\n\n\tBEM-VINDO AO JOGO DA SENHA");

        String senha = gerarSenha(comprimento);
        System.out.println("\nSenha: " + senha); // Esconder durante o jogo
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
            int contDigitosPosicaoErrada = 0; // Contador para números corretos na posição errada

            System.out.print("\nTENTATIVA: ");
            String tentativa = sc.next();

            // Verifica se está na posição correta e incrementa os contadores
            for (int i = 0; i < senha.length; i++) {
                if (senha[i] == tentativa.charAt(i)) {
                    contCorretos++;
                } else {
                    // Verifica se o número está correto, mas na posição errada
                    for (int j = 0; j < senha.length; j++) {
                        if (senha[j] == tentativa.charAt(i)) {
                            contDigitosPosicaoErrada++;
                            break;
                        }
                    }
                }
            }
    
            System.out.println("\nPOSIÇÕES CORRETAS: " + contCorretos);
            System.out.println("DIGITO NA POSIÇÃO ERRADA: " + contDigitosPosicaoErrada);
            
            // Verifica se todas as posições estão corretas
            if (contCorretos == senha.length) {
                System.out.println("\nPARABÉNS!! VOCÊ ACERTOU!");
                break;
            }

            // Contagem de chances e verificação se o jogador perdeu
            ponto--;
            System.out.println("CHANCES RESTANTES: " + ponto);

            if (ponto == 0) {
                System.out.println("\nSENHA INCORRETA! VOCÊ PERDEU TODAS AS SUAS CHANCES :(");
                break;
            }

        } while (true);
    }
}
