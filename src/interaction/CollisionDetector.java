package interaction;

public class CollisionDetector {
	
	// 1. keep list of all objects in the scene
	// 2. method to check if any of the objects touch each other
	
	// when a collision is detected compare the mass and velocity 
	
	/*
	 * LAWS
	 * conservation of energy:
	*		[1/2 * m1 * v1_ix^2] + [1/2 * m2 * v2_ix^2] = [1/2 * m1 * v1_fx^2] + [1/2 * m2 * v2_ix^2]
	*
	*	conservation of momentum:
	*		[m1 * v1_ix] + [m2 * v2_ix] = [m1 * v1_fx] + [m2 * v2_ix]
	 */
	
	
	/* 
	 * perfectly elastic collision
	*
	*		scenario 1: object 1 is launched towards object 2, which is initally at rest 
	*		v1_fx = [v1_ix*(m1 - m2)] / m1 + m2
	*		v2_fx = (2m1 * v1_ix) / m1 + m2
	*
	*
	*		scenario 2: object 1 is launched towards object 2, which is initally NOT at rest
	*		
	*		using reference frames: 
	*			frame L: lab frame, frame in which the collision takes place
	*			frame M: moves with object 2 within frame L and towards object 1
	*			goal is to have the whole collision seen in frame M so,
	*				object 2 will have 0 velocity in frame M and
	*				object 1 will get the velocity of (obj 1 + abs(obj 2))
	*
	*		// calculate initial velocities in frame M
	*		vLM_x = Math.abs(v2_ix);	(velocity of frame L relative to frame M)
	*		v1_ix_M = v1_ix + vLM_x; 	(init v of obj 1 as seen in frame M)
	*		v2_ix_M = v2_ix + vLM_x; 	(init v of obj 2 as seen in frame M)
	*
	*		// calculate final velocities in frame L
	*		v1_fx_M = [v1_ix_M *(m1 - m2)] / m1 + m2 (final v of obj 1 as seen in frame M)
	*		v2_fx_M = (2m1 * v1_ix_M) / m1 + m2		 (final v of obj 2 as seen in frame M)
	*		
	*		// transform back to frame L
	*		vML_x = -vLM_x;				(velocity of frame M relative to frame L)
	*		v1_fx = v1_fx_M + vML_x;	(final v of obj 1 as seen in frame L)
	*		v2_fx = v2_fx_M + vML_x;	(final v of obj 2 as seen in frame L)
	*/	
	
	/*
	 * perfectly inelastic collision (objects stick together)
	 * 		using: [m1 * v1_ix] + [m2 * v2_ix] = (m1 + m2) * v_fx
	 * 
	 * 		v_fx = v1_fx = v2_fx = [(m1 * v1_ix) + (m2 * v2_ix)] / (m1 + m2)
	 */
	
	
	
	public CollisionDetector() {}
}
