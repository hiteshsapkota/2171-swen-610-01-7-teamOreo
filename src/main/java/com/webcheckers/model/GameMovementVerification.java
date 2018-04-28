package com.webcheckers.model;


import com.webcheckers.model.WebCheckerGame.moveStatCode;
import java.util.ArrayList;
import com.webcheckers.model.WebCheckerGame.conversionState;
import java.util.HashMap;
import java.util.Objects;
import com.webcheckers.model.Board.Piece;
import com.webcheckers.model.Board.Piece.typeEnum;
import com.webcheckers.model.Board.Piece.colorEnum;
import static com.webcheckers.model.Strings.*;




public class GameMovementVerification {
	private WebCheckerGameProduct webCheckerGameProduct;
	private int numOfPiecesPlayer1;
	private int numOfPiecesPlayer2;
	private int numOfPossMovePlayer1;
	private int numOfPossMovePlayer2;
	private moveStatCode moveState;
	private final ArrayList<Movement> movements = new ArrayList<>();
	private conversionState conversion;
	private final HashMap<String, ArrayList<Position>> possibleMovements = new HashMap<>();

	public WebCheckerGameProduct getWebCheckerGameProduct() {
		return webCheckerGameProduct;
	}

	public void setWebCheckerGameProduct(WebCheckerGameProduct webCheckerGameProduct) {
		this.webCheckerGameProduct = webCheckerGameProduct;
	}

	public void setNumOfPiecesPlayer1(int numOfPiecesPlayer1) {
		this.numOfPiecesPlayer1 = numOfPiecesPlayer1;
	}

	public void setNumOfPiecesPlayer2(int numOfPiecesPlayer2) {
		this.numOfPiecesPlayer2 = numOfPiecesPlayer2;
	}

	public void setMoveState(moveStatCode moveState) {
		this.moveState = moveState;
	}

	public void setConversion(conversionState conversion) {
		this.conversion = conversion;
	}

	/**
	* Check if the there are pieces left for a player or opponent.
	* @return  true if there are no pieces left for a player, else false.
	*/
	public boolean checkIfPiecesLeftIsNone() {
		return numOfPiecesPlayer2 == 0 || numOfPiecesPlayer1 == 0;
	}

	/**
	* Checks if the user entered won or lost.
	* @param user  the user who wants to check
	* @return  true if the user won, else false.
	*/
	public boolean didIWin(String user) {
		return Objects.equals(user, webCheckerGameProduct.getPlayer1())
				? numOfPiecesPlayer1 != 0 && numOfPossMovePlayer1 != 0
				: numOfPiecesPlayer2 != 0 && numOfPossMovePlayer2 != 0;
	}

	/**
	* Checks if the number of possible moves is 0
	* @return  true if it is 0, else false.
	*/
	public boolean checkIfNoMovesLeft() {
		return numOfPossMovePlayer1 == 0 || numOfPossMovePlayer2 == 0;
	}

	/**
	* This function checks for all possible movements and stores it in a Hash Map.
	*/
	public void checkAllPieceForMovements(WebCheckerGame webCheckerGame) {
		this.numOfPossMovePlayer1 = 0;
		this.numOfPossMovePlayer2 = 0;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				if (webCheckerGame.getPiece(i, j) == null)
					continue;
				String positionKey = String.valueOf(i) + String.valueOf(j);
				possibleMovements.put(positionKey, new ArrayList<>());
				if (webCheckerGame.getPiece(i, j).getType() == typeEnum.KING) {
					if (i + 1 <= 7) {
						if (j + 1 <= 7) {
							if (webCheckerGame.getPiece(i + 1, j + 1) == null) {
								possibleMovements.get(positionKey).add(new Position(i + 1, j + 1));
								numOfPossMovePlayer1 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.RED)
										? numOfPossMovePlayer1 + 1
										: numOfPossMovePlayer1;
								numOfPossMovePlayer2 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.WHITE)
										? numOfPossMovePlayer2 + 2
										: numOfPossMovePlayer2;
							}
							if (i + 2 <= 7 && j + 2 <= 7 && webCheckerGame.getPiece(i + 1, j + 1) != null
									&& webCheckerGame.getPiece(i + 1, j + 1).getColor() != webCheckerGame.getPiece(i, j)
											.getColor()
									&& webCheckerGame.getPiece(i + 2, j + 2) == null) {
								possibleMovements.get(positionKey).add(new Position(i + 2, j + 2));
								numOfPossMovePlayer1 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.RED)
										? numOfPossMovePlayer1 + 1
										: numOfPossMovePlayer1;
								numOfPossMovePlayer2 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.WHITE)
										? numOfPossMovePlayer2 + 2
										: numOfPossMovePlayer2;
							}
						}
						if (j - 1 >= 0) {
							if (webCheckerGame.getPiece(i + 1, j - 1) == null) {
								possibleMovements.get(positionKey).add(new Position(i + 1, j - 1));
								numOfPossMovePlayer1 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.RED)
										? numOfPossMovePlayer1 + 1
										: numOfPossMovePlayer1;
								numOfPossMovePlayer2 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.WHITE)
										? numOfPossMovePlayer2 + 2
										: numOfPossMovePlayer2;
							}
							if (i + 2 <= 7 && j - 2 >= 0 && webCheckerGame.getPiece(i + 1, j - 1) != null
									&& webCheckerGame.getPiece(i + 1, j - 1).getColor() != webCheckerGame.getPiece(i, j)
											.getColor()
									&& webCheckerGame.getPiece(i + 2, j - 2) == null) {
								possibleMovements.get(positionKey).add(new Position(i + 2, j - 2));
								numOfPossMovePlayer1 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.RED)
										? numOfPossMovePlayer1 + 1
										: numOfPossMovePlayer1;
								numOfPossMovePlayer2 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.WHITE)
										? numOfPossMovePlayer2 + 2
										: numOfPossMovePlayer2;
							}
						}
					}
					if (i - 1 >= 0) {
						if (j + 1 <= 7) {
							if (webCheckerGame.getPiece(i - 1, j + 1) == null) {
								possibleMovements.get(positionKey).add(new Position(i - 1, j + 1));
								numOfPossMovePlayer1 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.RED)
										? numOfPossMovePlayer1 + 1
										: numOfPossMovePlayer1;
								numOfPossMovePlayer2 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.WHITE)
										? numOfPossMovePlayer2 + 2
										: numOfPossMovePlayer2;
							}
							if (i - 2 >= 0 && j + 2 <= 7 && webCheckerGame.getPiece(i - 1, j + 1) != null
									&& webCheckerGame.getPiece(i - 1, j + 1).getColor() != webCheckerGame.getPiece(i, j)
											.getColor()
									&& webCheckerGame.getPiece(i - 2, j + 2) == null) {
								possibleMovements.get(positionKey).add(new Position(i - 2, j + 2));
								numOfPossMovePlayer1 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.RED)
										? numOfPossMovePlayer1 + 1
										: numOfPossMovePlayer1;
								numOfPossMovePlayer2 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.WHITE)
										? numOfPossMovePlayer2 + 2
										: numOfPossMovePlayer2;
							}
						}
						if (j - 1 >= 0) {
							if (webCheckerGame.getPiece(i - 1, j - 1) == null) {
								possibleMovements.get(positionKey).add(new Position(i - 1, j - 1));
								numOfPossMovePlayer1 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.RED)
										? numOfPossMovePlayer1 + 1
										: numOfPossMovePlayer1;
								numOfPossMovePlayer2 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.WHITE)
										? numOfPossMovePlayer2 + 2
										: numOfPossMovePlayer2;
							}
							if (i - 2 >= 0 && j - 2 >= 0 && webCheckerGame.getPiece(i - 1, j - 1) != null
									&& webCheckerGame.getPiece(i - 1, j - 1).getColor() != webCheckerGame.getPiece(i, j)
											.getColor()
									&& webCheckerGame.getPiece(i - 2, j - 2) == null) {
								possibleMovements.get(positionKey).add(new Position(i - 2, j - 2));
								numOfPossMovePlayer1 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.RED)
										? numOfPossMovePlayer1 + 1
										: numOfPossMovePlayer1;
								numOfPossMovePlayer2 = (webCheckerGame.getPiece(i, j).getColor() == colorEnum.WHITE)
										? numOfPossMovePlayer2 + 2
										: numOfPossMovePlayer2;
							}
						}
					}
				} else if (webCheckerGame.getPiece(i, j).getColor() == colorEnum.RED) {
					if (i + 1 <= 7) {
						if (j + 1 <= 7) {
							if (webCheckerGame.getPiece(i + 1, j + 1) == null) {
								possibleMovements.get(positionKey).add(new Position(i + 1, j + 1));
								numOfPossMovePlayer1++;
							}
							if (i + 2 <= 7 && j + 2 <= 7 && webCheckerGame.getPiece(i + 1, j + 1) != null
									&& webCheckerGame.getPiece(i + 1, j + 1).getColor() != colorEnum.RED
									&& webCheckerGame.getPiece(i + 2, j + 2) == null) {
								possibleMovements.get(positionKey).add(new Position(i + 2, j + 2));
								numOfPossMovePlayer1++;
							}
						}
						if (j - 1 >= 0) {
							if (webCheckerGame.getPiece(i + 1, j - 1) == null) {
								possibleMovements.get(positionKey).add(new Position(i + 1, j - 1));
								numOfPossMovePlayer1++;
							}
							if (i + 2 <= 7 && j - 2 >= 0 && webCheckerGame.getPiece(i + 1, j - 1) != null
									&& webCheckerGame.getPiece(i + 1, j - 1).getColor() != colorEnum.RED
									&& webCheckerGame.getPiece(i + 2, j - 2) == null) {
								possibleMovements.get(positionKey).add(new Position(i + 2, j - 2));
								numOfPossMovePlayer1++;
							}
						}
					}
				} else if (webCheckerGame.getPiece(i, j).getColor() == colorEnum.WHITE) {
					if (i - 1 >= 0) {
						if (j + 1 <= 7) {
							if (webCheckerGame.getPiece(i - 1, j + 1) == null) {
								possibleMovements.get(positionKey).add(new Position(i - 1, j + 1));
								numOfPossMovePlayer2++;
							}
							if (i - 2 >= 0 && j + 2 <= 7 && webCheckerGame.getPiece(i - 1, j + 1) != null
									&& webCheckerGame.getPiece(i - 1, j + 1).getColor() != colorEnum.WHITE
									&& webCheckerGame.getPiece(i - 2, j + 2) == null) {
								possibleMovements.get(positionKey).add(new Position(i - 2, j + 2));
								numOfPossMovePlayer2++;
							}
						}
						if (j - 1 >= 0) {
							if (webCheckerGame.getPiece(i - 1, j - 1) == null) {
								possibleMovements.get(positionKey).add(new Position(i - 1, j - 1));
								numOfPossMovePlayer2++;
							}
							if (i - 2 >= 0 && j - 2 >= 0 && webCheckerGame.getPiece(i - 1, j - 1) != null
									&& webCheckerGame.getPiece(i - 1, j - 1).getColor() != colorEnum.WHITE
									&& webCheckerGame.getPiece(i - 2, j - 2) == null) {
								possibleMovements.get(positionKey).add(new Position(i - 2, j - 2));
								numOfPossMovePlayer2++;
							}
						}
					}
				}
			}
	}

	/**
	* Checks if the movement is a valid one or not and returns the appropriate method.
	* @param startRow  row position of the start.
	* @param startCell  cell position of the start.
	* @param endRow  row position of the end.
	* @param endCell  cell position of the end.
	* @return  the appropriate message.
	*/
	public Message isValidTurn(int startRow, int startCell, int endRow, int endCell, WebCheckerGame webCheckerGame) {
		Message message = new Message();
		String pieceKey = String.valueOf(startRow) + String.valueOf(startCell);
		if (moveState == moveStatCode.MOVEMENT_MADE
				|| moveState != moveStatCode.CAPTURE_MODE && !possibleMovements.containsKey(pieceKey)) {
			message.text = Strings.INVALID_ALREADY_MADE;
			message.type = Strings.MESSAGE_ERROR;
			possibleMovements.clear();
			this.checkAllPieceForMovements(webCheckerGame);
			return message;
		}
		ArrayList<Position> possibleMoves = possibleMovements.get(pieceKey);
		Position endPosition = new Position(endRow, endCell);
		if (possibleMoves.contains(endPosition))
			if (endRow - startRow == 2 || endRow - startRow == -2) {
				moveState = moveStatCode.CAPTURE_MODE;
				message.text = Strings.VALID_MOVE;
				message.type = Strings.MESSAGE_INFO;
			} else {
				moveState = moveStatCode.MOVEMENT_MADE;
				message.text = Strings.VALID_MOVE;
				message.type = Strings.MESSAGE_INFO;
			}
		else {
			moveState = moveStatCode.NO_MOVEMENT;
			message.text = Strings.INVALID_MOVE;
			message.type = Strings.MESSAGE_ERROR;
		}
		if (moveState == moveStatCode.MOVEMENT_MADE || moveState == moveStatCode.CAPTURE_MODE) {
			movements.add(new Movement(startRow, startCell, endRow, endCell));
			Piece piece = webCheckerGame.getPiece(startRow, startCell);
			webCheckerGame.setPiece(startRow, startCell, null);
			webCheckerGame.setPiece(endRow, endCell, piece);
			possibleMoves.clear();
			this.checkAllPieceForMovements(webCheckerGame);
		}
		if ((moveState == moveStatCode.MOVEMENT_MADE || moveState == moveStatCode.CAPTURE_MODE)
				&& (endRow == 7 && webCheckerGame.getPiece(endRow, endCell).getColor() == colorEnum.RED
						|| endRow == 0 && webCheckerGame.getPiece(endRow, endCell).getColor() == colorEnum.WHITE))
			conversion = conversionState.IN_CONVERSION;
		return message;
	}

	/**
	* Check if the undo is possible
	* @return  if successful, returns true else false.
	*/
	public boolean popMove(WebCheckerGame webCheckerGame) {
		boolean undoSuccessful = false;
		if (moveState != moveStatCode.CAPTURE_MODE) {
			Movement latestMovement = movements.get(movements.size() - 1);
			Piece piece = webCheckerGame.getPiece(latestMovement.getEndRow(), latestMovement.getEndCell());
			webCheckerGame.setPiece(latestMovement.getEndRow(), latestMovement.getEndCell(), null);
			webCheckerGame.setPiece(latestMovement.getStartRow(), latestMovement.getStartCell(), piece);
			moveState = moveStatCode.NO_MOVEMENT;
			undoSuccessful = true;
			movements.remove(movements.size() - 1);
			this.checkAllPieceForMovements(webCheckerGame);
		}
		return undoSuccessful;
	}

	/**
	* This function moves the piece and commits and switch of the current players' turn.
	*/
	public void makeMove(WebCheckerGame webCheckerGame) {
		for (int i = movements.size() - 1; i >= 0; i--) {
			if (moveState == moveStatCode.CAPTURE_MODE) {
				if (webCheckerGameProduct.getIsPlayer1Turn()) {
					numOfPiecesPlayer2--;
				} else if (webCheckerGameProduct.getIsPlayer2Turn()) {
					numOfPiecesPlayer1--;
				}
				if (webCheckerGameProduct.getIsPlayer1Turn()) {
					if (typeEnum.KING == webCheckerGame.getPiece(movements.get(movements.size() - 1).getEndRow(),
							movements.get(movements.size() - 1).getEndCell()).getType()) {
						if (movements.get(i).getEndRow() > movements.get(i).getStartRow()) {
							webCheckerGame.setPiece(movements.get(i).getStartRow() + 1,
									movements.get(i).getEndCell() > movements.get(i).getStartCell()
											? movements.get(i).getStartCell() + 1
											: movements.get(i).getStartCell() - 1,
									null);
						} else {
							if (movements.get(i).getStartCell() > movements.get(i).getEndCell()) {
								webCheckerGame.setPiece(movements.get(i).getStartRow() - 1,
										movements.get(i).getStartCell() - 1, null);
							} else {
								webCheckerGame.setPiece(movements.get(i).getStartRow() - 1,
										movements.get(i).getStartCell() + 1, null);
							}
						}
					} else {
						if (movements.get(i).getEndCell() > movements.get(i).getStartCell()) {
							webCheckerGame.setPiece(movements.get(i).getStartRow() + 1,
									movements.get(i).getStartCell() + 1, null);
						} else {
							webCheckerGame.setPiece(movements.get(i).getStartRow() + 1,
									movements.get(i).getStartCell() - 1, null);
						}
					}
				} else {
					if (webCheckerGame.getPiece(movements.get(movements.size() - 1).getEndRow(),
							movements.get(movements.size() - 1).getEndCell()).getType() == typeEnum.KING) {
						if (movements.get(i).getEndRow() > movements.get(i).getStartRow()) {
							webCheckerGame.setPiece(movements.get(i).getStartRow() + 1,
									movements.get(i).getEndCell() > movements.get(i).getStartCell()
											? movements.get(i).getStartCell() + 1
											: movements.get(i).getStartCell() - 1,
									null);
						} else {
							webCheckerGame.setPiece(movements.get(i).getStartRow() - 1,
									movements.get(i).getStartCell() > movements.get(i).getEndCell()
											? movements.get(i).getStartCell() - 1
											: movements.get(i).getStartCell() + 1,
									null);
						}
					} else {
						if (movements.get(i).getStartCell() > movements.get(i).getEndCell()) {
							webCheckerGame.setPiece(movements.get(i).getStartRow() - 1,
									movements.get(i).getStartCell() - 1, null);
						} else {
							webCheckerGame.setPiece(movements.get(i).getStartRow() - 1,
									movements.get(i).getStartCell() + 1, null);
						}
					}
				}
			}
			if (conversion == conversionState.IN_CONVERSION) {
				webCheckerGame.getPiece(movements.get(i).getEndRow(), movements.get(i).getEndCell())
						.setType(typeEnum.KING);
				conversion = conversionState.NO_CONVERSION;
			}
		}
		if (webCheckerGameProduct.getIsPlayer1Turn()) {
			webCheckerGameProduct.setIsPlayer1Turn(false);
			webCheckerGameProduct.setIsPlayer2Turn(true);
		} else {
			webCheckerGameProduct.setIsPlayer2Turn(false);
			webCheckerGameProduct.setIsPlayer1Turn(true);
		}
		movements.clear();
		moveState = moveStatCode.NO_MOVEMENT;
		conversion = conversionState.NO_CONVERSION;
		possibleMovements.clear();
	}

	/**
	* Checks if the game is ended or not.
	* @return  true if the game has ended, else false.
	*/
	public boolean isGameEnded() {
		boolean gameEnded = false;
		if (checkIfNoMovesLeft() || checkIfPiecesLeftIsNone()) {
			gameEnded = true;
		}
		return gameEnded;
	}
}