package com.itgenius.ministockkotlin.model

data class ProductModelItem(
    val CategoryID: Int,
    val CreatedDate: String,
    val ModifiedDate: String,
    val ProductID: Int,
    val ProductName: String,
    val ProductPicture: String,
    val UnitInStock: Int,
    val UnitPrice: Int,
    val _id: String,
    val category: List<Category>
)


data class Category(
    val CategoryID: Int,
    val CategoryName: String,
    val CategoryStatus: Int,
    val CreatedDate: String,
    val ModifiedDate: String,
    val _id: String
)
// .NET Framework Project