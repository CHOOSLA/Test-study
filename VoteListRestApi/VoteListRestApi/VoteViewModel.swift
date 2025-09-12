//
//  VoteViewModel.swift
//  VoteListRestApi
//
//  Created by choosla on 9/12/25.
//

import Foundation

@MainActor
class VoteViewModel: Observable{
  @Published var votes: [Vote] = []
  
  private let networkManager: NetworkManager.shared
  
  func fetchVotes() async {
    votes = await networkManager.fetchVotes()
  }
  
  func addVote(title: String, description: String) async {
    if let newVote = await networkManager.createVote(title: title, description: description){
      votes.append(newVote)
    }
  }
}
