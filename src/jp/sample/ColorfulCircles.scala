package jp.sample
import javafx.stage.Stage
import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.StrokeType
import javafx.scene.effect.BoxBlur
import javafx.scene.shape.Rectangle
import javafx.scene.paint.LinearGradient
import javafx.scene.paint.CycleMethod
import javafx.scene.paint.Stop
import javafx.scene.effect.BlendMode
import javafx.animation.Timeline
import scala.collection.JavaConversions._
import javafx.animation.KeyFrame
import javafx.util.Duration
import javafx.animation.KeyValue
import javafx.beans.value.WritableValue

object ColorfulCircles {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[ColorfulCircles], args: _*)
  }

}

class ColorfulCircles extends javafx.application.Application {
  override def start(primaryStage: Stage) {
    val root = new Group
    val scene = new Scene(root, 800, 600, Color.BLACK)
    primaryStage.setScene(scene)

    val circles = new Group
    for (i <- 1 to 30) {
      val circle = new Circle(150, Color.web("white", 0.05))
      circle.setStrokeType(StrokeType.OUTSIDE)
      circle.setStroke(Color.web("white", 0.16))
      circle.setStrokeWidth(4)
      circles.getChildren().add(circle)
    }

    val colors = new Rectangle(scene.getWidth(), scene.getHeight(),
      new LinearGradient(0, 1, 1, 0, true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.web("#f8bd55")),
        new Stop(0.14, Color.web("#c0fe56")),
        new Stop(0.28, Color.web("#5dfbc1")),
        new Stop(0.43, Color.web("#64c2f8")),
        new Stop(0.57, Color.web("#be4af7")),
        new Stop(0.71, Color.web("#ed5fc2")),
        new Stop(0.85, Color.web("#ef504c")),
        new Stop(1, Color.web("#f2660f"))))
    //root.getChildren().add(colors)
    //root.getChildren().add(circles)

    val blendModeGroup = new Group(
      new Group(
        new Rectangle(scene.getWidth(),
          scene.getHeight(),
          Color.BLACK), circles),
      colors)

    colors.setBlendMode(BlendMode.OVERLAY)
    root.getChildren().add(blendModeGroup)

    circles.setEffect(new BoxBlur(10, 10, 3))

    val timeline = new Timeline()
    circles.getChildren().foreach(c => timeline.getKeyFrames().addAll(
      new KeyFrame(Duration.ZERO,
        new KeyValue(c.translateXProperty().asInstanceOf[WritableValue[Double]], Math.random * 800),
        new KeyValue(c.translateYProperty().asInstanceOf[WritableValue[Double]], Math.random * 600)),
      new KeyFrame(new Duration(10000),
        new KeyValue(c.translateXProperty().asInstanceOf[WritableValue[Double]], Math.random * 800),
        new KeyValue(c.translateYProperty().asInstanceOf[WritableValue[Double]], Math.random * 600))))

    timeline.setCycleCount(10)
    timeline.setAutoReverse(true)
    timeline.play()

    primaryStage.show()
  }
}