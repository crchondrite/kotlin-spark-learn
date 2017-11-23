package entity

data class Items(
        var _id: String,
        var name: String,
        var value: Int,
        var enabled: Boolean,
        var variations: List<Variation>
) {
    constructor(): this(
            "", "", 0, false, listOf()
    )
}

data class Variation(
        var id: Int,
        var value:String
) {
    constructor(): this(
            0, ""
    )
}

