package org.rul.nutrimake

import org.rul.nutrimake.model.Cliente

/**
 * Created by Rul on 12/10/2017.
 */
class TestUtil{
    companion object Factory {
        fun createCliente(): Cliente = Cliente(null, null)
    }
}