import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;


public class MainPruebaCompiladores {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
		frequencyAnalyzer.setWordFrequenciesToReturn(300);
		frequencyAnalyzer.setMinWordLength(4);
		
		List<String> listaWords = new ArrayList<String>();
		listaWords.add("Volumen");
		listaWords.add("Largo");
		//frequencyAnalyzer.setStopWords(loadStopWords());
		frequencyAnalyzer.setStopWords(listaWords);

		FileInputStream fis = new FileInputStream("C:\\Users\\Usuario\\Desktop\\filename.txt");
		
		//final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(getInputStream("text/datarank.txt"));
		final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(fis);
		//final Dimension dimension = new Dimension(500, 312);
		final Dimension dimension = new Dimension(500, 312);
		final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
		wordCloud.setPadding(2);
		
		//wordCloud.setBackground(new PixelBoundryBackground(getInputStream("backgrounds/whale_small.png")));
		//InputStream image = new Imageinp("C:\\Users\\Usuario\\Desktop\\whale_small.png");
		
		File imageFile = new File("C:\\Users\\Usuario\\Desktop\\whale_small.png");
		FileInputStream is = new FileInputStream(imageFile);
		
		wordCloud.setBackground(new PixelBoundryBackground(is));
		
		wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
		wordCloud.setFontScalar(new LinearFontScalar(10, 40));
		
		wordCloud.build(wordFrequencies);
		wordCloud.writeToFile("C:\\Users\\Usuario\\Desktop\\whale_small_salida.png");

	}

}
