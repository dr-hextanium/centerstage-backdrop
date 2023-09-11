fun main(args: Array<String>) {
    val backdrop = Backdrop()

    backdrop.place(0, 0, PixelType.Purple)
    backdrop.place(0, 1, PixelType.Yellow)
    backdrop.place(0, 2, PixelType.Green)


    println(backdrop)
    println("${backdrop.score(Backdrop.Period.Autonomous)} points")
}