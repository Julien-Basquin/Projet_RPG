package generateur;

import org.apache.log4j.Logger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.file.FileChooser;
import com.kotcrab.vis.ui.widget.file.FileTypeFilter;

import com.kotcrab.vis.ui.widget.file.FileChooser.Mode;
import com.kotcrab.vis.ui.widget.file.FileChooser.SelectionMode;

import generateur.model.entity_parameters.stack.EventStack;
import generateur.view.global.GlobalParametersContents;
import generateur.view.global.GlobalParametersPane;

/**
 * Classe principale du générateur, contient la logique de base de l'application.
 * 
 * @author Julien B.
 */

public class MainWindow extends ApplicationAdapter {

	/**Contient tous les éléments graphiques.*/
	public static Skin skin;
	/**Conteneur des éléments graphiques avec prise en compte des intéractions utilisateur.*/
	public static Stage stage;
	/**Permet d'ouvrir une fenêtre et de sélectionner un fichier de l'ordinateur*/
	public static FileChooser fileChooser;
	public static InputMultiplexer inputMultiplexer;
	/**Logger*/
	private final Logger logger = Logger.getLogger(MainWindow.class);
	
	public static SplitPane mainSplit;
	public static EventStack previousStates;
	public static EventStack nextStates;
	/**
	 * Called when the Application is first created.
	 */
	@Override
	public void create() {
		logger.info("Starting generator...");

		// set full screen
		if (Launcher.configuration.getBoolean("Config.General.Fullscreen")) {
			Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		}
		
		skin = new Skin(new FileHandle("ressources/generateur/skin/default/uiskin.json"));
		stage = new Stage();
		
		//Chargement de VisUI et du sélecteur de fichier
		//Voir https://github.com/kotcrab/vis-ui
		VisUI.load();
		FileChooser.setDefaultPrefsName("generateur.filechooser");
		fileChooser = new FileChooser(Mode.OPEN);
		fileChooser.setSelectionMode(SelectionMode.FILES);
		fileChooser.setDirectory("ressources/generateur/");
		FileTypeFilter typeFilter = new FileTypeFilter(true);
		typeFilter.addRule("Image files (*.png, *.jpg, *.gif)", "png", "jpg", "gif");
		fileChooser.setFileTypeFilter(typeFilter);
		
		//Création des deux zones du générateur
		mainSplit = new SplitPane(new GlobalParametersPane(skin), null, false, skin);
		mainSplit.setName("generator");
		//Verrouillage de la séparation
		mainSplit.setMinSplitAmount(0.33f);
		mainSplit.setSplitAmount(0.33f);
		mainSplit.setMaxSplitAmount(0.33f);
		stage.addActor(mainSplit);
		//Filling category fields
		((GlobalParametersContents) mainSplit.findActor("global_contents")).fireCategorySelect();
		mainSplit.setFillParent(true);
		
		//Configuration de la réception des inputs
		inputMultiplexer = new InputMultiplexer(stage);
		
		//Création des piles d'états
		previousStates = new EventStack();
		nextStates = new EventStack();
		
		Gdx.input.setInputProcessor(inputMultiplexer);
		
		logger.info("...generator started");
	}

	/**
	 * Called when the Application is resized.
	 */
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
	}

	/**
	 * Called when the Application should render itself.
	 */
	@Override
	public void render() {
		//rafraîchissement de l'écran
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Affichage des acteurs du stage
		stage.draw();
		stage.act();
	}

	/**
	 * Called when the Application is paused, usually when it's not active or visible on-screen.
	 */
	@Override
	public void pause() {
		super.pause();
	}

	/**
	 * Called when the Application is resumed from a paused state, usually when it regains focus.
	 */
	@Override
	public void resume() {
		super.resume();
	}

	/**
	 * Called when the Application is destroyed.
	 */
	@Override
	public void dispose() {
		logger.info("...closing generator.");
		((GlobalParametersPane) mainSplit.findActor("global_pane")).dispose();
		stage.dispose();
		skin.dispose();
		VisUI.dispose();
	}
	
//	public static void clearNextStates() {
//		Pattern pattern = Pattern.compile("^(!:[A-Z]+)_([A-Z])*");
//		Matcher match;
//		
//		
//		for (ObjectEvent objectEvent : nextStates) {
//			match = pattern.matcher(objectEvent.getEvent());
//			if (match.find()) {
//				String regexClass = match.group(1);
//				regexClass = regexClass.toLowerCase();
//				regexClass = regexClass.replaceFirst("" + regexClass.charAt(0), "" + (regexClass.charAt(0) - 22));
//				//TODO TESTER
//				((Disposable) objectEvent).dispose();
//			}
//		}
//		
//		nextStates.clear();
//	}
}