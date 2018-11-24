package com.razvanpopescu.socialresp.models


class CommentModel {

    var id: Long? = null

    var author: UserModel? = null

    var date: String? = null

    var text: String? = null

    var upvotes: List<UserModel>? = null

    var downvotes: List<UserModel>? = null

}