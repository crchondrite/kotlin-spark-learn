package entity

data class Items(
        var _id: String,
        var name: String,
        var value: Int,
        var enabled: Boolean
) {
    constructor(): this(
            "", "", 0, false
    )
}

