//
//  VoteViewModel.swift
//  VoteListRestApi
//
//  Created by choosla on 9/12/25.
//

import Foundation
import UIKit

@MainActor
class VoteViewModel: ObservableObject{
  @Published var votes: [Vote] = []
  
  private let networkManager = NetworkManager.shared
  
  func fetchVotes() async {
    votes = await networkManager.fetchVotes()
  }
  
//  func addVote(title: String, description: String) async {
//    if let newVote = await networkManager.createVote(title: title, description: description){
//      votes.append(newVote)
//    }
//  }
  
  func addVote(title: String, description: String, image: UIImage?) async {
    if let newVote = await networkManager.createVote(title: title, description: description, image: image){
      votes.append(newVote)
    }
  }
  
  func updateVote(vote: Vote) async {
    if let updatedVote = await
        networkManager.updateVote(vote: vote){
      if let index = votes.firstIndex(where: {
        $0.id == updatedVote.id
      }) {
        votes[index] = updatedVote
      }
    }
  }
  
  func deleteVote(id: Int) async {
    if await networkManager.deleteVote(id: id){
      votes.removeAll{ $0.id == id}
    }
  }
}
