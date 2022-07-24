package domain.car

data class Position(
    private val position: Int
) {
    companion object {
        const val MIN_POSITION: Int = 0
        private const val MOVABLE_DISTANCE: Int = 1

        fun default(): Position = Position(MIN_POSITION)
    }

    init {
        require(position >= MIN_POSITION) {
            "position($position}은 $MIN_POSITION 이하 일 수 없습니다."
        }
    }

    fun increase(): Position = Position(position + MOVABLE_DISTANCE)
}
