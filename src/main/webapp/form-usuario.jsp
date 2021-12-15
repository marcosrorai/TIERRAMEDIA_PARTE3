<!-- MAIN SECTION -->
	<main>
		<!-- Product -->
		<section class="product-section">
			<div class="product-container content-wrapper">
				<div class="product-content">
					<div class="product-image">
						<img src="/torre/assets/img/frodo.png" alt="product" />
					</div>
					<div class="product-box">

						<div class="mb-0">
							<label for="username" class="col-form-label">Nombre:</label> <input
								type="text" class="form-control" id="username" name="username" required
								value="${tmp_user.nombre}">
						</div>
						<div class="mb-0">
							<label for="coins"
								class='col-form-label ${tmp_user.errores.get("coins") != null ? "is-invalid" : "" }'>Presupuesto:</label>
							<input class="form-control" type="number" id="coins" name="coins"
								required value="${tmp_user.presupuesto}"></input>
							<div class="invalid-feedback">
								<c:out value='${tmp_user.errores.get("coins")}'></c:out>
							</div>
						</div>
						<div class="mb-0">
							<label for="time"
								class='col-form-label ${tmp_user.errores.get("time") != null ? "is-invalid" : "" }'>Tiempo:</label>
							<input class="form-control" type="number" id="time" name="time"
								name="duration" required value="${tmp_user.tiempoDisponible}"></input>
							<div class="invalid-feedback">
								<c:out value='${tmp_user.errores.get("time")}'></c:out>
							</div>
						</div>
						
                           <div class="mb-3">
							<label for="preferencia"
								class='col-form-label ${tmp_user.errores.get("preferencia") != null ? "is-invalid" : "" }'>Tipo:</label>
							<input class="form-control" type="text" id="preferencia"
								name="tipo" required value="${tmp_user.preferencia}"></input>
							<div class="invalid-feedback">
								<c:out value='${tmp_user.errores.get("preferencia")}'></c:out>
							</div>
						</div>
                        
						
				

						<div>
							<button type="submit" class="btn btn-primary">Guardar</button>
							<a onclick="window.history.back();" class="btn btn-secondary"
								role="button">Cancelar</a>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>