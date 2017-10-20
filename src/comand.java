
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author u4239
 */
public class comand {

    private static Executar UIExecutar = new Executar();

    public static boolean exec(String comandoCMD) {

        Process executar;

        try {

            executar = Runtime.getRuntime().exec(comandoCMD);

            if (executar.waitFor() == 0) {
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {

            System.out.println("Erro: " + e.getMessage());

        } catch (InterruptedException e) {

            System.out.println("Erro: " + e.getMessage());
        }

        return false;

    }

    public static String command(String enderecoExecutavel, String enderecoProjeto) {
        //Cria uma linha a ser executada no CMD
        return enderecoExecutavel + " -start -run -proj " + enderecoProjeto + "\r\n";
    }

    public static String commandDump(String enderecoExecutavel, String enderecoProjeto) {
        //Cria uma linha a ser executada no CMD
        return enderecoExecutavel + " -dump -stop -proj " + enderecoProjeto + "\r\n";
    }

    public static boolean save(String comandoCMD, String dir, String nomeProj) throws IOException {

        try {

            String name = nomeArquivo("Salvar arquivo começado pelo projeto " + nomeProj + " como: ");

            if (name != null) {

                File diretorio;
                diretorio = new File(dir, name.concat(".bat"));

                //Verifica se o diretorio ja existe
                while (fileExists(diretorio)) {
                    name = nomeArquivo("Arquivo já existe, digite um nome diferente para o arquivo; ");
                    diretorio = new File(dir, name.concat(".bat"));
                }

                FileWriter arq = new FileWriter(diretorio, true);

                System.out.println(comandoCMD);
                PrintWriter gravarArq = new PrintWriter(arq);

                //Cria um novo arquivo com os dados
                gravarArq.printf(comandoCMD);

                arq.close();

                return true;
            }

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());
            return false;
        }
        return false;
    }

    public static boolean fileExists(File file) {

        return file.exists();
    }

    public static void exibeMensagem(String msg, String titulo) {

        JOptionPane.showMessageDialog(UIExecutar, msg, titulo, JOptionPane.INFORMATION_MESSAGE);

    }

    public static String nomeArquivo(String msg) {

        Executar exec = new Executar();
        
        if (msg != null) {

            if (msg.contains("Arquivo já existe")) {
                return JOptionPane.showInputDialog(exec, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            }else{
                return JOptionPane.showInputDialog(msg);
            }
        }
        return null;
    }
}
