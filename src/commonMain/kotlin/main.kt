import com.snakegame.scenes.GameScene
import com.snakegame.scenes.LoadingScene
import com.snakegame.scenes.MainMenuScene
import com.soywiz.korge.Korge
import com.soywiz.korge.scene.Module
import com.soywiz.korge.scene.Scene
import com.soywiz.korim.color.Colors
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korma.geom.SizeInt
import kotlin.reflect.KClass

suspend fun main() = Korge(Korge.Config(module = SnakeGameModule))

object SnakeGameModule : Module() {
	override val title = "Snake Game"
	override val size = SizeInt(800, 600)
	override val windowSize = SizeInt(800, 600)

	override val bgcolor = Colors["#2b2b2b"]
	override val mainScene: KClass<out Scene> = GameScene::class//LoadingScene::class

	override suspend fun init(injector: AsyncInjector): Unit = injector.run {
		//mapInstance(Resources())
		mapPrototype { LoadingScene(/*get()*/) }
		mapPrototype { MainMenuScene(/*get()*/) }
		mapPrototype { GameScene(/*get()*/) }
	}
}





