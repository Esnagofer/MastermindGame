/**
 * 
 */
package com.esnagofer.mastermind.infrastructure.adapter.db.domain.model.gameboard.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.esnagofer.lib.ddd.infrastrucutre.adapter.db.repository.memory.MemoryRepositoryImpl;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoard;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardId;
import com.esnagofer.mastermind.domain.model.gameboard.GameBoardRepository;

/**
 * The Class GameBoardRepositoryImpl.
 *
 * @author user
 */
@Component
public class GameBoardRepositoryImpl extends MemoryRepositoryImpl<GameBoard, GameBoardId> implements GameBoardRepository {

	/** The content. */
	private static Map<GameBoardId, GameBoard> content = new ConcurrentHashMap<>();

	/* (non-Javadoc)
	 * @see com.esnagofer.infrastrucutre.adapter.db.repository.memory.MemoryRepositoryImpl#content()
	 */
	@Override
	protected Map<GameBoardId, GameBoard> content() {
		return content;
	}
	
}
