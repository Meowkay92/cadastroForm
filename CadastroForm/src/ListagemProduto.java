import java.util.*;

public class ListagemProduto {
    private static final List<Produto> listaProdutos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = solicitarOpcao();

            switch (opcao) {
                case 1:
                    cadastrarNovoProduto();
                    break;
                case 2:
                    listarProdutosPorValor();
                    break;
                case 3:
                    System.out.println("Encerrando...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n*** Cadastro e Listagem de Produtos ***");
        System.out.println("Escolha uma das opções: ");
        System.out.println("1- Cadastrar novo produto");
        System.out.println("2- Listar produtos por valor");
        System.out.println("3- Sair");
    }

    private static int solicitarOpcao() {
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    private static void cadastrarNovoProduto() {
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("\n*** Cadastrar Novo Produto ***");

        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição do Produto: ");
        String descricaoProduto = scanner.nextLine();

        double valor = 0;
        boolean valorValido = false;
        while (!valorValido) {
            try {
                System.out.print("Valor do Produto: ");
                valor = Double.parseDouble(scanner.nextLine());
                valorValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número válido para o valor do produto.");
            }
        }

        System.out.print("Disponível para venda (sim ou não): ");
        boolean disponivelParaVenda = scanner.nextLine().equalsIgnoreCase("sim");

        Produto novoProduto = new Produto(nome, descricaoProduto, valor, disponivelParaVenda);
        listaProdutos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!\n");

        // Ordena a lista de produtos por valor após cada cadastro
        listaProdutos.sort(Comparator.comparingDouble(Produto::getValor));

        // Exibe a listagem atualizada
        listarProdutosPorValor();
    }

    public static void listarProdutosPorValor() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Lista de produtos está vazia.");
        } else {
            System.out.println("\n*** Lista de Produtos Ordenados por Valor ***");

            for (Produto produto : listaProdutos) {
                if (produto.isDisponivelParaVenda()) {
                    System.out.println("Nome: " + produto.getNome() + " | Valor: " + produto.getValor());
                }
            }
            System.out.println();
        }
    }
}
