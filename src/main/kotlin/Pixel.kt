data class Pixel(val type: PixelType = PixelType.None)

enum class PixelType {
    White,
    Purple,
    Green,
    Yellow,

    None
}