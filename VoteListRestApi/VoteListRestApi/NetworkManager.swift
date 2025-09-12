//
//  NetworkManager.swift
//  VoteListRestApi
//
//  Created by choosla on 9/12/25.
//

import Foundation
import Alamofire

class NetworkManager{
  static let shared = NetworkManager()
  private let baseURL = "http://192.168.202.121:8080"
  
  func fetchVotes() async -> [Vote] {
    do{
      let response = try await AF.request("\(baseURL)/votes", method : .get)
        .serializingDecodable([Vote].self)
        .value
      return response;
    }catch{
      print("투표 목록 조회 실패 : \(error)")
      return []
    }
  }
  
  func createVote(title: String, description: String) async -> Vote? {
    let params: [String: Any] = ["title": title, "description": description]
    
    return try? await AF.request(
      "\(baseURL)/votes",
      method : .post,
      parameters : paramters,
      encoding : JSONEncoding.default
    )
    .serializingDecodable([Vote].self)
    .value
    
  }
}
