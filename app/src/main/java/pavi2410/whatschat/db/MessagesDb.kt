package pavi2410.whatschat.db

import pavi2410.whatschat.models.MessageModel

val messagesDb = listOf(
    MessageModel("Hi"),
    MessageModel("Hi", true),
    MessageModel("I'm Foo Bar"),
    MessageModel("You are so genius!!! 😍"),
    MessageModel("Foo", true),
    MessageModel("Bar"),
    MessageModel("LOL 😂", true),
    MessageModel("Bye 👋 See you again!")
)