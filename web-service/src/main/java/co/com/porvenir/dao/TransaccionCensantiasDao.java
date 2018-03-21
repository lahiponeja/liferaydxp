/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 14/03/2018
 * @since 0.0.1 14/03/2018
 */
package co.com.porvenir.dao;

import co.com.porvenir.entidad.TransaccionCensantias;

/**
 * Dao para la entidad TransaccionCensantias
 * @author Alejandro Vivas
 * @since 0.0.1 14/03/2018
 * @version 0.0.1 14/03/2018
 */
public interface TransaccionCensantiasDao
{
	/**
	 * Agrega una TransaccionCensantias
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param transaccionCensantias Transaccion que se agrega
	 * @return Id de la transaccion agregada
	 */
	public long agregar(TransaccionCensantias transaccionCensantias);
}
