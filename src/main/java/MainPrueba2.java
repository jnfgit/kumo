import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.EmojiWordCloudITest;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.FontWeight;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;


public class MainPrueba2 {

	private static final Random RANDOM = new Random();
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
	    final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
	    frequencyAnalyzer.setWordFrequenciesToReturn(600);
	    frequencyAnalyzer.setMinWordLength(5);
	    
	    //frequencyAnalyzer.setStopWords(loadStopWords());
		List<String> listaWords = new ArrayList<String>();
		listaWords.add("Volumen");
		listaWords.add("Largo");
		frequencyAnalyzer.setStopWords(listaWords);

		
	    //final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(new FileInputStream("/tmp/code.txt"));
		FileInputStream fis = new FileInputStream("C:\\Users\\Usuario\\Desktop\\filename.txt");
		final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(fis);
		
		
		
		
	    final Dimension dimension = new Dimension(600, 600);
	    final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
	    wordCloud.setPadding(1);
	    wordCloud.setBackground(new CircleBackground(300));
	    wordCloud.setBackgroundColor(Color.WHITE);
	    wordCloud.setColorPalette(buildRandomColorPalette(2));
	    
	    //wordCloud.setKumoFont(new KumoFont("Helvitica", FontWeight.PLAIN));
	    //wordCloud.setKumoFont(new KumoFont(EmojiWordCloudITest.class.getResourceAsStream("/font/OpenSansEmoji.ttf")));
	    
	    InputStream inp = new FileInputStream("C:\\Users\\Usuario\\Documents\\javaparserKumo\\src\\test\\resources\\font\\OpenSansEmoji.ttf");
	    wordCloud.setKumoFont(new KumoFont(inp));
	    
	    
	    wordCloud.setFontScalar(new LinearFontScalar(8, 130));
	    
	    //wordCloud.build(wordFrequencies);
	    wordCloud.build(buildWordFrequencies());
	    
	    wordCloud.writeToFile("C:\\Users\\Usuario\\Desktop\\wordcloud_match_online_example.png");
	    
	}
	
    private static ColorPalette buildRandomColorPalette(int n) {
        final Color[] colors = new Color[n];
        for(int i = 0; i < colors.length; i++) {
            colors[i] = new Color(RANDOM.nextInt(230) + 25, RANDOM.nextInt(230) + 25, RANDOM.nextInt(230) + 25);
        }
        return new ColorPalette(colors);
    }
    
    private static List<WordFrequency> buildWordFrequencies() {
        final List<WordFrequency> wordFrequencies = new ArrayList<>();
        for (final String emoji : EMOJIS) {
            wordFrequencies.add(new WordFrequency(emoji, RANDOM.nextInt(250)));
        }
        return wordFrequencies;
    }
    
    private static final String[] EMOJIS = {
            "Vocabulario",
            "Longitud",
            "Volumen",
            "Nivel",
            "Dificultad",
            "Esfuerzo",
            "Tiempo",
            "Contenido",
            /*
            "\uD83D\uDE02",
            "\uD83D\uDC4D",
            "\uD83D\uDE0A",
            "\uD83D\uDE01",
            "\uD83D\uDE12",
            "\uD83D\uDE11",
			"\uD83D\uDE0D",
            "\uD83D\uDC4C",
            "\uD83D\uDE2D",		
            "\uD83D\uDE4C",		//Feliz Manos Arriba
			"\uD83D\uDE29",
            "\uD83D\uDE21",
     		"\uD83D\uDE21",
     		"\uD83D\uDE32",
     		"\uD83D\uDE31",
            "\uD83D\uDE0F",
            */
    };
}
