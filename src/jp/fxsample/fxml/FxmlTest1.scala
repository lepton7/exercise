package jp.fxsample.fxml
import java.util.ResourceBundle

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

object FxmlTest1 {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[FxmlTest1], args:_*)
  }

}

class FxmlTest1 extends javafx.application.Application {

  @FXML private var buttonStatusText : Label = null

  @FXML private var usernameField : TextField = null

  @FXML
  def handleSubmitButtonAction(event : ActionEvent) {
    buttonStatusText.setText("Submit button pressed")
  }

  @FXML
  def handlePasswordFieldAction(event : ActionEvent) {
    usernameField.getText()
    buttonStatusText.setText(
        if(usernameField.getText == "")
          "Enter your name"
        else
          "Enter key pressed")
  }

  override def start(stage : Stage) {
    stage.setTitle("FXML Example")

    val root : Parent = FXMLLoader.load(getClass().getResource("fxml_example.fxml"),
        ResourceBundle.getBundle("jp.fxsample.fxml.fxml_example"))
    val scene = new Scene(root, 226, 264)
    stage.setScene(scene);

    stage.show
  }
}