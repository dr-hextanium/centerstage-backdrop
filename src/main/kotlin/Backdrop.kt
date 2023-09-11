class Backdrop {
    private val grid = MutableList(SIZE) { MutableList(SIZE - ((it + 1) % 2)) { Pixel() } }

    private val flattened
        get() = grid.flatten().filter { it.type != PixelType.None }

    fun neighbors(row: Int, column: Int, direction: Direction) {

    }

    fun score(period: Period): Int {
        val value = when (period) {
            Period.Autonomous -> 5
            Period.DriverController -> 3
        }

        val pixels = flattened.sumOf { value }

        return pixels + mosaics() + setLines()
    }

    fun setLines(): Int {
        return 0
    }

    fun mosaics(): Int {
        return 0
    }

    fun place(row: Int, column: Int, type: PixelType) {
        grid[row][column] = Pixel(type)
    }

    override fun toString(): String {
        fun color(type: PixelType) = when (type) {
            PixelType.White -> "⬜"
            PixelType.Purple -> "\uD83D\uDFEA"
            PixelType.Green -> "\uD83D\uDFE9"
            PixelType.Yellow -> "\uD83D\uDFE8"
            PixelType.None -> "⬛"
        }

        fun prefix(index: Int) = if (index % 2 == 0) "" else ""

        return grid.reversed()
            .mapIndexed { index, pixels ->
                prefix(index) + pixels.joinToString(" ") { color(it.type) }
            }.joinToString("\n")
    }

    companion object {
        const val SIZE = 7
    }

    enum class Period {
        Autonomous,
        DriverController
    }

    enum class Direction {
        Left,
        Right,
        TopLeft,
        TopRight,
        BottomLeft,
        BottomRight
    }
}

