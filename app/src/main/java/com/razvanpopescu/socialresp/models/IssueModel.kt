package com.razvanpopescu.socialresp.models

class Issue {

    var id: Long? = null

    var author: UserModel? = null

    var title: String? = null

    var date: String? = null

    var text: String? = null

    var clat: String? = null

    var clong: String? = null

    var image: ByteArray? = null

    var comments: List<CommentModel>? = null

    var upvotes: List<UserModel>? = null

    var downvotes: List<UserModel>? = null
}