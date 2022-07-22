import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
        
        // lê a imagem
        // InputStream inputStream = new FileInputStream(new File("images/entrada/filmeOriginal.jpg"));
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BN2EwM2I5OWMtMGQyMi00Zjg1LWJkNTctZTdjYTA4OGUwZjMyXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        // cria nova imagem em memoria com trasparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 56);
        graphics.setColor(Color.PINK);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("teste", 0/*(imagemOriginal.getWidth()-(imagemOriginal.getWidth()/2))*/, novaAltura - 100);

        //escrever a nova imagem em um arquivo
        String path = "/c:/users/tulio/desktop/imersao-java/imersao-java/images/saida/";
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}
