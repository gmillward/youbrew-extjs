/*
 * Description: Recipe service, implements the recipe dao interface & extends the baseDao
 * 
 * @author: jacob heric
 * @created: 1/27/2010
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   see <http://www.gnu.org/licenses/>.
 *
 */
package com.jacobheric.youbrew.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacobheric.youbrew.dao.contract.IRecipeDAO;
import com.jacobheric.youbrew.dao.criteria.RecipeCriteria;
import com.jacobheric.youbrew.domain.Recipe;
import com.jacobheric.youbrew.service.contract.IRecipeService;

@Service("recipeService")
public class RecipeServiceImpl implements IRecipeService {

	@Autowired
	IRecipeDAO recipeDAO;

	public Recipe insert(Recipe recipe) {
		return (Recipe) this.recipeDAO.insert(recipe);
	}

	public Recipe update(Recipe recipe) {
		return (Recipe) this.recipeDAO.update(recipe);
	}

	public void delete(Recipe recipe) {
		this.recipeDAO.delete(recipe);
	}

	public void deleteById(Long id) {
		this.delete(this.findById(id));
	}

	public Recipe findById(Long id) {
		return (Recipe) this.recipeDAO.findById(id);
	}

	public List<Recipe> findByExample(Recipe exampleClass,
			String[] excludeProperty) {
		return (List<Recipe>) this.recipeDAO.findByExample(exampleClass,
				excludeProperty);
	}

	public List<Recipe> findAll() {
		return (List<Recipe>) this.recipeDAO.findAll();
	}

	public List<Recipe> search(RecipeCriteria criteria) {
		return this.recipeDAO.search(criteria);
	}

}
