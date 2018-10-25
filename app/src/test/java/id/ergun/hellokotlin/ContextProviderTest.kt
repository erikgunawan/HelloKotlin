package id.ergun.hellokotlin

import kotlinx.coroutines.experimental.Unconfined
import kotlin.coroutines.experimental.CoroutineContext


class ContextProviderTest : CoroutineContextProvider() {
    override val main: CoroutineContext = Unconfined
}