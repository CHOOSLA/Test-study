//
//  Vote.swift
//  VoteListRestApi
//
//  Created by choosla on 9/12/25.
//

import Foundation

class Vote : Codable, Identifiable{
  let id: Int
  let title: String
  let description: String
}
